package org.example

import org.springframework.stereotype.Service

@Service
class GreetingService(val repository: GreetingRepository) {
    @Suppress("FunctionOnlyReturningConstant")
    fun getMessage(): String =
        repository.findTopByOrderByCreatedAtDesc()?.message ?: "Check back soon."
}
