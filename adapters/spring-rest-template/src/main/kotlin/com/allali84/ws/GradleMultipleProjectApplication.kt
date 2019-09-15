package com.allali84.ws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import org.springframework.boot.web.client.RestTemplateBuilder



@SpringBootApplication
class GradleMultipleProjectApplication {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        // Do any additional configuration here
        return builder.build()
    }
}

fun main(args: Array<String>) {
    runApplication<GradleMultipleProjectApplication>(*args)
}

