package com.example.urlshortener.controllers

import com.example.urlshortener.controllers.requests.CreateShortUrlRequest
import com.example.urlshortener.controllers.responses.CreateShortUrlResponse
import com.example.urlshortener.services.UrlShortenerService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlShortenerController(val service: UrlShortenerService) {
    @PostMapping("/short-links")
    fun createShortUrl(@RequestBody body: CreateShortUrlRequest): CreateShortUrlResponse {
        val shortUrl = service.createShortURL(body.url)
        return CreateShortUrlResponse(shortUrlId = shortUrl.shortUrlId, url=shortUrl.url, createdAt = shortUrl.createdAt)
    }
}