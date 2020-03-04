package org.example

import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface GreetingRepository : JpaRepository<Greeting, UUID> {
    fun findTopByOrderByCreatedAtDesc(): Greeting?
}
