package com.allali84.jpa


import com.allali84.jpa.model.FaqJpa
import org.springframework.data.jpa.repository.JpaRepository

internal interface RepositoryJpaImpl: JpaRepository<FaqJpa, Long> {
    fun findFaqByQuestion(question: String): FaqJpa?
}