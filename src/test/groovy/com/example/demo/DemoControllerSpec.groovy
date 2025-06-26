package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content

@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration // <-- Add this annotation
class DemoControllerSpec extends Specification {

    @Autowired
    private MockMvc mockMvc // <-- Make sure this is a field, not a property

    def "should echo the posted message"() {
        given:
        def message = "Hello World"

        expect:
        mockMvc.perform(post("/api/echo")
                .contentType("text/plain")
                .content(message))
                .andExpect(status().isOk())
                .andExpect(content().string("Received: $message"))
    }
}