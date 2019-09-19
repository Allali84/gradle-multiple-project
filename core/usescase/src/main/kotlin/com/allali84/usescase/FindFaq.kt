package com.allali84.usescase

import com.allali84.entities.Faq
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository

class FindFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun findByQuestion(question: String): Faq {
        return faqRepository.findFaqByQuestion(question) ?: throw QuestionNotFoundException("This question : $question not Found")
    }
    fun findAll() = faqRepository.findAll()
}