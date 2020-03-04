package org.example

import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Greeting(
    @Id val id: UUID,
    val createdAt: Instant,
    val message: String
)
