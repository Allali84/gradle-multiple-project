package com.allali84.spring.jpa.model


import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name= "FAQ")
data class FaqJpa(
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        var id: Long? = null,
        @NotNull
        var question: String = "",
        @NotNull
        var answer: String = "",
        @NotNull
        @Column(name="date_question")
        var dateQuestion: Date = Date())