package com.allali84.db

import com.allali84.entities.Faq
import com.allali84.usescase.port.FaqRepository
import java.util.HashMap

class FaqRepositoryInMemorySimpleImpl: FaqRepository {

    private val inMemoryDb = HashMap<String, Faq>()

    override fun findFaqByQuestion(question: String): Faq? {
        return inMemoryDb[question]
    }

    override fun findAll(): List<Faq> = inMemoryDb.values.toList()

    override fun create(faq: Faq): Faq {
        inMemoryDb[faq.question] = faq
        return faq
    }

    override fun delete(faq: Faq): Faq {
        inMemoryDb.remove(faq.question)
        return faq
    }
}