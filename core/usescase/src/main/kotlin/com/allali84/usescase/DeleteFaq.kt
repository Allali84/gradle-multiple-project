package com.allali84.usescase

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionAlreadyExistsException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository

class DeleteFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun delete(faq: Faq): Faq {
        faqRepository.findFaqByQuestion(faq.question) ?: throw QuestionNotFoundException("This question : ${faq.question} is nonexistent")
        return faqRepository.delete(faq)
    }
}