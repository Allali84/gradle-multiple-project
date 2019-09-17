package com.allali84.spring.config

import com.allali84.spring.jpa.FaqRepositoryJpaImpl
import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SpringConfig {

    @Autowired
    private lateinit var faqRepositoryJpaImpl: FaqRepositoryJpaImpl

    fun createFaqJpa() : CreateFaq {
        return CreateFaq(faqRepositoryJpaImpl)
    }

    fun deleteFaqJpa() : DeleteFaq {
        return DeleteFaq(faqRepositoryJpaImpl)
    }

    fun findFaqJpa() : FindFaq {
        return FindFaq(faqRepositoryJpaImpl)
    }

}