package com.allali84.spring.jpa.model


import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity(name= "FAQ")
data class FaqJpa(
        @Id
        var id: Long? = null,
        @NotNull
        val question: String,
        @NotNull
        val answer: String,
        @NotNull
        @Column(name="date_question")
        val dateQuestion: Date)