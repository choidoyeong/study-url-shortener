package com.example.urlshortener

import com.example.urlshortener.controllers.requests.CreateShortUrlRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@AutoConfigureMockMvc
@SpringBootTest
class ShortUrlApplicationTests (@Autowired private val mockMvc: MockMvc) {

    @Test
    fun createShortUrl() {
        val requestBody = jacksonObjectMapper().writeValueAsString(CreateShortUrlRequest(url = "http://test.com"))
        val action= mockMvc.perform(MockMvcRequestBuilders.post("/short-links")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody)
        )
        action.andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.url").value("http://test.com"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.shortUrlId").value("MQ=="))
    }

}
