package com.allali84.spring.ws.model

import java.io.Serializable
import java.util.*
import javax.validation.constraints.NotNull

data class FaqWS(
        @NotNull
        var questionFromWs: String = "",
        @NotNull
        var answerFromWs: String = "",
        @NotNull
        var dateQuestionFromWs: Date = Date(),
        var infoFromWs: String = ""
): Serializable