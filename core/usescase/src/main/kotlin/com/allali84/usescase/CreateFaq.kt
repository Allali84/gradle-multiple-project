package com.allali84.usescase

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionAlreadyExistsException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository

class CreateFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun create(faq: Faq): Faq {
        if (faqRepository.findFaqByQuestion(faq.question) != null) {
            throw QuestionAlreadyExistsException("This question : ${faq.question} already exist")
        }
        return faqRepository.create(faq)
    }
}