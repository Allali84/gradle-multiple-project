package com.allali84.config

import com.allali84.db.FaqRepositoryInMemorySimpleImpl
import com.allali84.hazelcast.FaqRepositoryHazelcastImpl
import com.allali84.usescase.CreateFaq
import com.allali84.usescase.DeleteFaq
import com.allali84.usescase.FindFaq

class ManualConfig {

    private val faqInMemoryRepository = FaqRepositoryInMemorySimpleImpl()
    private val faqHazelcastRepository = FaqRepositoryHazelcastImpl()

    fun createFaq() : CreateFaq {
        return CreateFaq(faqInMemoryRepository)
    }

    fun deleteFaq() : DeleteFaq {
        return DeleteFaq(faqInMemoryRepository)
    }

    fun findFaq() : FindFaq {
        return FindFaq(faqInMemoryRepository)
    }
}