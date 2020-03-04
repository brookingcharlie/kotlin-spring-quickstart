package org.example

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(val greetingService: GreetingService) {
    @GetMapping("/", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hello() = GreetingResponse(greetingService.getMessage())
}

data class GreetingResponse(val message: String)
