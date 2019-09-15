package com.allali84.ws

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository
import com.allali84.ws.model.FaqWS
import com.allali84.ws.model.ListFaqWS
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class FaqRepositoryWSImpl: FaqRepository {

    @Autowired
    private lateinit var template: RestTemplate

    override fun findFaqByQuestion(question: String): Faq? {
        val faqWs = template.getForEntity("URL?question=$question", FaqWS::class.java)
        val body = faqWs.body ?: throw QuestionNotFoundException("Question Not Found")
        return Faq(body.question, body.answer, body.dateQuestion)
    }

    override fun findAll(): List<Faq> {
        val faqWs = template.getForEntity("URL", ListFaqWS::class.java)
        val body = faqWs.body ?: throw QuestionNotFoundException("Question Not Found")
        if (body.faqWSs.isNullOrEmpty()) throw QuestionNotFoundException("Question Not Found")
        return body.faqWSs.map { Faq(it.question, it.answer, it.dateQuestion) }
    }

    override fun create(faq: Faq): Faq {
        template.postForEntity("URL",FaqWS(faq.question, faq.answer, faq.dateQuestion), FaqWS::class.java)
        // TODO Manage the errors
        return faq
    }

    override fun delete(faq: Faq): Faq {
        template.delete("URL",FaqWS(faq.question, faq.answer, faq.dateQuestion), FaqWS::class.java)
        // TODO Manage the errors
        return faq
    }
}