package org.example

import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(ExampleController::class)
@ExtendWith(MockKExtension::class)
internal class ExampleControllerIT {
    @TestConfiguration
    class TestConfig {
        @Bean
        fun exampleService(): ExampleService = mockk(relaxed = true)
    }

    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var exampleService: ExampleService

    @BeforeEach
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `should return message`() {
        every { exampleService.getMessage() } returns "Hello, world!"
        mockMvc.get("/example") {
            accept = MediaType.APPLICATION_JSON
        }.andExpect {
            status { isOk }
            content { contentType(MediaType.APPLICATION_JSON) }
            jsonPath("$.message") { value("Hello, world!") }
        }
    }
}
