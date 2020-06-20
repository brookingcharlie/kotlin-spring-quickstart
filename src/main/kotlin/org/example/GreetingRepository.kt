package org.example

import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface GreetingRepository : JpaRepository<Greeting, UUID> {
    fun findTopByOrderByCreatedAtDesc(): Greeting?
}
