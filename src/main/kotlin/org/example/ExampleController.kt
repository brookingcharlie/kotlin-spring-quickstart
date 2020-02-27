package org.example

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController {
    @GetMapping("/hello", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hello() = Greeting("Hello, world!")
}

data class Greeting(val message: String)
