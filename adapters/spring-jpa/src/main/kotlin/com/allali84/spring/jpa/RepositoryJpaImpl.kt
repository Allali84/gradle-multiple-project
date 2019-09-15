package com.allali84.spring.jpa


import com.allali84.spring.jpa.model.FaqJpa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository


interface RepositoryJpaImpl: JpaRepository<FaqJpa, Long> {
    fun findFaqByQuestion(question: String): FaqJpa?
}