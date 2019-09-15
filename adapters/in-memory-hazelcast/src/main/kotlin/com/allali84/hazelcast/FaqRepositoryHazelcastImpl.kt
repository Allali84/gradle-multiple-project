package com.allali84.hazelcast

import com.allali84.entities.Faq
import com.allali84.hazelcast.model.FaqDb
import com.allali84.usescase.exception.QuestionNotFoundException
import com.allali84.usescase.port.FaqRepository

class FaqRepositoryHazelcastImpl: FaqRepository {

    private val MAP_NAME = "faq"

    override fun findFaqByQuestion(question: String): Faq? {
        val map: MutableMap<String, FaqDb> = Hazelcast.HAZELCAST.getMap(MAP_NAME)
        val list = map.values.filter { it.question == question }
        return if (list.isEmpty()) {
            throw QuestionNotFoundException("Question Not Found")
        } else {
            list.map { Faq(it.question, it.answer, it.dateQuestion) }[0]
        }
    }

    override fun findAll(): List<Faq> {
        val map: MutableMap<String, FaqDb> = Hazelcast.HAZELCAST.getMap(MAP_NAME)
        return map.values.map { Faq(it.question, it.answer, it.dateQuestion) }
    }

    override fun create(faq: Faq): Faq {
        val faqDb = FaqDb(faq.question, faq.answer, faq.dateQuestion)
        val map: MutableMap<String, FaqDb> = Hazelcast.HAZELCAST.getMap(MAP_NAME)
        map[faqDb.question] = faqDb
        return faq
    }

    override fun delete(faq: Faq): Faq {
        val map: MutableMap<String, FaqDb> = Hazelcast.HAZELCAST.getMap(MAP_NAME)
        map.remove(faq.question)
        return faq
    }

}