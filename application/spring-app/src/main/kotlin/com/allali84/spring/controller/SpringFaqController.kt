package com.allali84.spring.controller


import com.allali84.entities.Faq
import com.allali84.spring.config.SpringConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.DeleteMapping

@RestController
class SpringFaqController {

    @Autowired
    private lateinit var springConfig: SpringConfig

    @PostMapping(value = ["/faqs"])
    fun createFaq(@RequestBody faq: Faq): Faq {
        return springConfig.createFaq().create(faq)
    }

    @GetMapping(value = ["/faqs"])
    fun findAllFaqs(): List<Faq> {
        return springConfig.findFaq().findAll()
    }

    @GetMapping(value = ["/faqs/{question}"])
    fun findAllFaqBy(@PathVariable("question") question: String): Faq? {
        return springConfig.findFaq().findByQuestion(question)
    }

    @DeleteMapping(value = ["/faqs"])
    fun deleteFaq(@RequestBody faq: Faq): Faq {
        return springConfig.deleteFaq().delete(faq)
    }
}