package com.allali84.spring.config

import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq
import com.allali84.spring.ws.FaqRepositoryWSImpl
import org.springframework.stereotype.Component

@Component
class SpringConfig(private val faqRepositoryWSImpl: FaqRepositoryWSImpl)  {

    fun createFaq() : CreateFaq {
        return CreateFaq(faqRepositoryWSImpl)
    }

    fun deleteFaq() : DeleteFaq {
        return DeleteFaq(faqRepositoryWSImpl)
    }

    fun findFaq() : FindFaq {
        return FindFaq(faqRepositoryWSImpl)
    }
}