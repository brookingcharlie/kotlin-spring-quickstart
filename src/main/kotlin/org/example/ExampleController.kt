package org.example

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ExampleController(val exampleService: ExampleService) {
    @GetMapping("/example", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hello() = ExampleResponse(exampleService.getMessage())
}

data class ExampleResponse(val message: String)
