package com.allali84.hazelcast.model


import java.util.*


data class FaqDb(val question: String,
                 val answer: String,
                 val dateQuestion: Date)