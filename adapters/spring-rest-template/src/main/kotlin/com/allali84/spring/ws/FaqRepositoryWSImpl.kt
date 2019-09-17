package com.allali84.spring.ws

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository
import com.allali84.spring.ws.model.FaqWS
import com.allali84.spring.ws.model.ListFaqWS
import org.mockserver.serialization.model.DTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import javax.annotation.PostConstruct

@Component
class FaqRepositoryWSImpl: FaqRepository {

    @PostConstruct
    fun startAndInitMockServer() {
        mockServer.init()
    }

    override fun findFaqByQuestion(question: String): Faq? {
        val faqWs = e2eRestTemplate.getForEntity("http://localhost:1080/faqs-source/faq?questionFromWs=$question", FaqWS::class.java)
        val body = faqWs.body ?: throw QuestionNotFoundException("Question Not Found")
        return Faq(body.questionFromWs, body.answerFromWs, body.dateQuestionFromWs)
    }

    override fun findAll(): List<Faq> {
        val faqWs = e2eRestTemplate.getForEntity("http://localhost:1080/faqs-source/faqs", Array<FaqWS>::class.java)
        val body = faqWs.body ?: throw QuestionNotFoundException("Question Not Found")
        return body.map { Faq(it.questionFromWs, it.answerFromWs, it.dateQuestionFromWs) }
    }

    override fun create(faq: Faq): Faq {
        e2eRestTemplate.postForEntity("URL", FaqWS(faq.question, faq.answer, faq.dateQuestion), FaqWS::class.java)
        // TODO Manage the errors
        return faq
    }

    override fun delete(faq: Faq): Faq {
        e2eRestTemplate.delete("URL", FaqWS(faq.question, faq.answer, faq.dateQuestion), FaqWS::class.java)
        // TODO Manage the errors
        return faq
    }
}