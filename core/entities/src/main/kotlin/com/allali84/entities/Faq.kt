package com.allali84.entities

import java.util.*
import javax.validation.constraints.NotNull

data class Faq(
        @NotNull
        val question: String,
        @NotNull
        val answer: String,
        @NotNull
        val dateQuestion: Date
)