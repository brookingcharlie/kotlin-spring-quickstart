package org.example

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isNull
import java.time.Instant
import java.util.UUID
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
internal class GreetingRepositoryIT {
    @Autowired
    lateinit var entityManager: TestEntityManager

    @Autowired
    lateinit var repository: GreetingRepository

    @Test
    fun `find latest should return latest greeting`() {
        val messages = listOf(
            Greeting(UUID.randomUUID(), Instant.ofEpochSecond(1), "Testing"),
            Greeting(UUID.randomUUID(), Instant.ofEpochSecond(2), "Testing again")
        )
        messages.forEach { entityManager.persist(it) }

        val latest = repository.findTopByOrderByCreatedAtDesc()
        assertThat(latest).isEqualTo(messages.last())
    }

    @Test
    fun `find latest should return null when no greetings`() {
        val greeting = repository.findTopByOrderByCreatedAtDesc()
        assertThat(greeting).isNull()
    }
}
