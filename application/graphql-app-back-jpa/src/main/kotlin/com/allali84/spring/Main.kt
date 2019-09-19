package com.allali84.spring


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import graphql.ExceptionWhileDataFetching
import graphql.GraphQLError
import java.util.ArrayList
import java.util.stream.Collectors
import com.allali84.spring.exception.GraphQLErrorAdapter
import graphql.servlet.GraphQLErrorHandler
import org.springframework.context.annotation.Bean
import java.util.function.Predicate


@SpringBootApplication
class Main {

    @Bean
    fun errorHandler(): GraphQLErrorHandler {
        return object : GraphQLErrorHandler {
            override fun processErrors(errors: List<GraphQLError>): List<GraphQLError> {
                val clientErrors = errors
                        .filter{ this.isClientError(it) }

                val serverErrors = errors
                        .filter { e -> !isClientError(e) }
                        .map{ GraphQLErrorAdapter(it) }

                val e = ArrayList<GraphQLError>()
                e.addAll(clientErrors)
                e.addAll(serverErrors)
                return e
            }

            protected fun isClientError(error: GraphQLError): Boolean {
                return !(error is ExceptionWhileDataFetching || error is Throwable)
            }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}