package com.allali84.spring.resolvers

import com.allali84.config.ManualConfig
import com.allali84.entities.Faq
import com.allali84.spring.exception.QuestionAlreadyExistsGraphqlException
import com.allali84.spring.exception.QuestionNotFoundGraphqlException
import com.allali84.usescase.exception.QuestionAlreadyExistsException
import com.allali84.usescase.exception.QuestionNotFoundException
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component

@Component
class MutationFaqResolver(private val manualConfig: ManualConfig): GraphQLMutationResolver {

    fun createFaq(faq: Faq): Faq {
        try {
            return manualConfig.createFaq().create(faq)
        } catch (e: QuestionAlreadyExistsException) {
            throw QuestionAlreadyExistsGraphqlException(e, faq.question)
        }
    }

    fun deleteFaq(faq: Faq): Faq {
        try {
            return manualConfig.deleteFaq().delete(faq)
        } catch (e: QuestionNotFoundException) {
            throw QuestionNotFoundGraphqlException(e, faq.question)
        }
    }
}