package com.allali84.spring.jpa

import com.allali84.entities.Faq
import com.allali84.spring.jpa.model.FaqJpa
import com.allali84.usescase.port.FaqRepository
import org.springframework.stereotype.Component
import org.springframework.beans.factory.annotation.Autowired

@Component
class FaqRepositoryJpaImpl: FaqRepository {

    @Autowired
    private lateinit var repository: RepositoryJpaImpl


    override fun findFaqByQuestion(question: String): Faq? {
        val faqJpa = repository.findFaqByQuestion(question)
        faqJpa ?: return null
        return Faq(faqJpa.question, faqJpa.answer, faqJpa.dateQuestion)
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
        if (faqJpa != null) {
            repository.delete(faqJpa)
        }
        return faq
    }
}