package com.allali84.usescase

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionAlreadyExistsException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository

class CreateFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun create(faq: Faq): Faq {
        try {
            if (faqRepository.findFaqByQuestion(faq.question) != null) {
                throw QuestionAlreadyExistsException(faq.question)
            }
        } catch (e: QuestionNotFoundException) {
            //TODO log this exception
        }

        return faqRepository.create(faq)
    }
}