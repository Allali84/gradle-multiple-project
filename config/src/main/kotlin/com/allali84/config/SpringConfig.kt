package com.allali84.config

import com.allali84.jpa.FaqRepositoryJpaImpl
import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq
import com.allali84.ws.FaqRepositoryWSImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SpringConfig {

    @Autowired
    private lateinit var faqRepositoryJpaImpl: FaqRepositoryJpaImpl
    @Autowired
    private lateinit var faqRepositoryWSImpl: FaqRepositoryWSImpl

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