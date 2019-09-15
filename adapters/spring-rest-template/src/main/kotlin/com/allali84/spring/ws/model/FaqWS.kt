package com.allali84.spring.ws.model

import java.util.*
import javax.validation.constraints.NotNull

data class FaqWS(
        @NotNull
        val question: String,
        @NotNull
        val answer: String,
        @NotNull
        val dateQuestion: Date
)