package com.allali84.console

import com.allali84.config.ManualConfig
import com.allali84.entities.Faq
import java.util.*


fun main() {

    // Setup
    val config = ManualConfig()
    val createFaq = config.createFaq()
    val findFaq = config.findFaq()
    val deleteFaq = config.deleteFaq()
    val faq = Faq("Question Example ?", "Answer!!", Date())

    // Create a faq
    val actualCreateFaq = createFaq.create(faq)
    println("Faq created with question ${actualCreateFaq.question}")

    // Find a faq by Question
    val actualFindUser = findFaq.findByQuestion(actualCreateFaq.question)
    println("Found faq with question ${actualFindUser?.question}")


    val faq2 = Faq("Question Example 2 ?", "Answer 2!!", Date())
    createFaq.create(faq2)

    // List all faqs
    var faqs = findFaq.findAll()
    println("List all users: $faqs")

    // Login
    deleteFaq.delete(faq)
    faqs = findFaq.findAll()
    println("List all users after delete : $faqs")
}