package com.allali84.spring.ws

import org.intellij.lang.annotations.Language
import org.mockserver.integration.ClientAndServer
import org.mockserver.model.Header
import org.mockserver.model.Parameter
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.client.ClientHttpResponse
import org.springframework.web.client.DefaultResponseErrorHandler
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.HttpServerErrorException
import org.springframework.web.client.RestTemplate

val e2eRestTemplate: RestTemplate = RestTemplateBuilder()
        .rootUri("http://localhost:8082")
        .errorHandler(object : DefaultResponseErrorHandler() {
            override fun handleError(response: ClientHttpResponse) {
                try {
                    super.handleError(response)
                } catch (exc: HttpServerErrorException) {
                    System.err.println("${exc.statusCode}: ${exc.responseBodyAsString}")
                    throw exc
                } catch (exc: HttpClientErrorException) {
                    System.err.println("${exc.statusCode}: ${exc.responseBodyAsString}")
                    throw exc
                }
            }
        })
        .build()

val mockServer: ClientAndServer by lazy {
    ClientAndServer.startClientAndServer(1080)
}

fun ClientAndServer.init() {
    @Language("JSON")
    val body = """
                        [
                            {
                                "questionFromWs": "question 1",
                                "answerFromWs": "answer 1",
                                "dateQuestionFromWs": "2019-09-16T22:00:00.000+0000"
                            },
                            {
                                "questionFromWs": "question 2",
                                "answerFromWs": "answer 2",
                                "dateQuestionFromWs": "2019-09-17T22:00:00.000+0000"
                            }
                        ]
                    """.trimIndent()
    @Language("JSON")
    val body2 = """
                            {
                                "questionFromWs": "question 1",
                                "answerFromWs": "answer 1",
                                "dateQuestionFromWs": "2019-09-16T22:00:00.000+0000"
                            }
                    """.trimIndent()
    `when`(
            org.mockserver.model.HttpRequest.request()
                    .withMethod("GET")
                    .withPath("/faqs-source/faqs")
    ).respond(
            org.mockserver.model.HttpResponse.response().withHeaders(
                    Header("Content-Type", "application/json; charset=utf-8"))
                    .withBody(body)
    )
    `when`(
            org.mockserver.model.HttpRequest.request()
                    .withMethod("GET")
                    .withPath("/faqs-source/faq")
                    .withQueryStringParameter(
                            Parameter.param("questionFromWs", "question")
                    )
    ).respond(
            org.mockserver.model.HttpResponse.response().withHeaders(
                    Header("Content-Type", "application/json; charset=utf-8"))
                    .withBody(body2)
    )
}