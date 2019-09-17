package com.allali84.spring.config

import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq
import com.allali84.spring.ws.FaqRepositoryWSImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class SpringConfig {

    @Autowired
    private lateinit var faqRepositoryWSImpl: FaqRepositoryWSImpl

    fun createFaqWs() : CreateFaq {
        return CreateFaq(faqRepositoryWSImpl)
    }

    fun deleteFaqWs() : DeleteFaq {
        return DeleteFaq(faqRepositoryWSImpl)
    }

    fun findFaqWs() : FindFaq {
        return FindFaq(faqRepositoryWSImpl)
    }
}