package org.example

import assertk.assertThat
import assertk.assertions.isEqualTo
import org.junit.jupiter.api.Test

internal class ExampleServiceTest {
    @Test
    fun `should return message`() {
        val service = ExampleService()
        val message = service.getMessage()
        assertThat(message).isEqualTo("Hello, world!")
    }
}
