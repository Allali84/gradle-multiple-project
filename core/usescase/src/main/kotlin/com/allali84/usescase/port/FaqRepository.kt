package com.allali84.usescase.port

import com.allali84.entities.Faq

interface FaqRepository {

    fun findFaqByQuestion(question: String): Faq?
    fun findAll(): List<Faq>
    fun create(faq: Faq): Faq
    fun delete(faq: Faq): Faq

}