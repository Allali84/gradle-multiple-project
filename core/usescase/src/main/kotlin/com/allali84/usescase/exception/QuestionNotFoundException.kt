package com.allali84.usescase.exception

class QuestionNotFoundException(question: String?) : RuntimeException(question)