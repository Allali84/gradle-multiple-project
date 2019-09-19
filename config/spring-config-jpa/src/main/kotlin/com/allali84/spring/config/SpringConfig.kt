package com.allali84.spring.config

import com.allali84.spring.jpa.FaqRepositoryJpaImpl
import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq
import org.springframework.stereotype.Component

@Component
class SpringConfig(private val faqRepositoryJpaImpl: FaqRepositoryJpaImpl) {

    fun createFaq() : CreateFaq {
        return CreateFaq(faqRepositoryJpaImpl)
    }

    fun deleteFaq() : DeleteFaq {
        return DeleteFaq(faqRepositoryJpaImpl)
    }

    fun findFaq() : FindFaq {
        return FindFaq(faqRepositoryJpaImpl)
    }

}