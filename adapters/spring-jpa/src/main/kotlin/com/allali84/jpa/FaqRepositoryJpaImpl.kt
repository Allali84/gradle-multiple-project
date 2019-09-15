package com.allali84.jpa

import com.allali84.entities.Faq
import com.allali84.jpa.model.FaqJpa
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

@Component
class FaqRepositoryJpaImpl: FaqRepository {

    @Autowired
    private lateinit var repository: RepositoryJpaImpl


    override fun findFaqByQuestion(question: String): Faq? {
        val faqJpa = repository.findFaqByQuestion(question)
        return if (faqJpa == null) {
            throw QuestionNotFoundException("Question Not Found")
        } else {
            Faq(faqJpa.question, faqJpa.answer, faqJpa.dateQuestion)
        }
    }

    override fun findAll(): List<Faq> {
        return repository.findAll().map { Faq(it.question, it.answer, it.dateQuestion) }
    }

    override fun create(faq: Faq): Faq {
        repository.save(FaqJpa(question = faq.question, answer = faq.answer, dateQuestion = faq.dateQuestion))
        return faq
    }

    override fun delete(faq: Faq): Faq {
        val faqJpa = repository.findFaqByQuestion(faq.question)
        if (faqJpa == null) {
            throw QuestionNotFoundException("Question to be deleted Not Found")
        } else {
            repository.delete(faqJpa)
        }
        return faq
    }
}