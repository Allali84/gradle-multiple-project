package com.allali84.usescase

import com.allali84.entities.Faq
import com.allali84.usescase.port.FaqRepository

class DeleteFaq constructor(
        private val faqRepository: FaqRepository
) {
    fun delete(faq: Faq) = faqRepository.delete(faq)
}