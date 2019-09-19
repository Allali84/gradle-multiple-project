package com.allali84.spring.types

import graphql.language.StringValue
import graphql.schema.Coercing
import graphql.schema.GraphQLScalarType
import org.springframework.stereotype.Component
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


@Component
class DateScalarType internal constructor()// ...
    : GraphQLScalarType("Date", "Date custom scalar type", object : Coercing<Date, String> {
    override fun parseValue(input: Any?): Date {
        input ?: return Date()
        val value = input as StringValue
        return try {
            SimpleDateFormat("yyyy-MM-dd").parse(value.value)
        } catch (e: ParseException) {
            Date()
        }
    }

    override fun parseLiteral(input: Any?): Date {
        input ?: return Date()
        val value = input as StringValue
        return try {
            SimpleDateFormat("yyyy-MM-dd").parse(value.value)
        } catch (e: ParseException) {
            Date()
        }
    }

    override fun serialize(dataFetcherResult: Any?): String {
        dataFetcherResult ?: return ""
        return dataFetcherResult.toString()
    }

})