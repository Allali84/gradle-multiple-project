package com.allali84.jpa.model


import java.util.*
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
        val dateQuestion: Date)