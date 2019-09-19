package com.allali84.spring.resolvers


import com.allali84.entities.Faq
import com.allali84.spring.config.SpringConfig
import com.allali84.spring.exception.QuestionNotFoundGraphqlException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class QueryFaqResolver(private val springConfig: SpringConfig): GraphQLQueryResolver  {

    fun findAllFaqs(): List<Faq> {
        return springConfig.findFaq().findAll()
    }

    fun findFaqByQuestion(question: String): Faq? {
        try {
            return springConfig.findFaq().findByQuestion(question)
        } catch (e: QuestionNotFoundException) {
            throw QuestionNotFoundGraphqlException(e, question)
        }
    }


}