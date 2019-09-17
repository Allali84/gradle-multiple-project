package com.allali84.usescase

import com.allali84.usescase.port.FaqRepository

class FindFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun findByQuestion(question: String) = faqRepository.findFaqByQuestion(question)
    fun findAll() = faqRepository.findAll()
}