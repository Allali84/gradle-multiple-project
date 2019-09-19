package com.allali84.spring.resolvers


import com.allali84.config.ManualConfig
import com.allali84.entities.Faq
import com.allali84.spring.exception.QuestionNotFoundGraphqlException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class QueryFaqResolver(private val manualConfig: ManualConfig): GraphQLQueryResolver  {

    fun findAllFaqs(): List<Faq> {
        return manualConfig.findFaq().findAll()
    }

    fun findFaqByQuestion(question: String): Faq? {
        try {
            return manualConfig.findFaq().findByQuestion(question)
        } catch (e: QuestionNotFoundException) {
            throw QuestionNotFoundGraphqlException(e, question)
        }
    }


}