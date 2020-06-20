package org.example

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.time.Instant
import java.util.UUID

@ExtendWith(MockKExtension::class)
internal class GreetingServiceTest {
    lateinit var service: GreetingService

    @MockK(relaxed = true)
    lateinit var repository: GreetingRepository

    @BeforeEach
    fun setUp() {
        clearAllMocks()
        service = GreetingService(repository)
    }

    @Test
    fun `should return latest greeting when have one`() {
        every { repository.findTopByOrderByCreatedAtDesc() } returns
            Greeting(UUID.randomUUID(), Instant.MIN, "Hello, world!")
        assertThat(service.getMessage()).isEqualTo("Hello, world!")
    }

    @Test
    fun `should return default greeting when have none`() {
        every { repository.findTopByOrderByCreatedAtDesc() } returns null
        assertThat(service.getMessage()).isEqualTo("Check back soon.")
    }
}
