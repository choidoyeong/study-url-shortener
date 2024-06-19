package com.example.urlshortener.controllers

import com.example.urlshortener.controllers.requests.CreateShortUrlRequest
import com.example.urlshortener.controllers.responses.ShortUrlResponse
import com.example.urlshortener.models.ShortUrl
import com.example.urlshortener.services.UrlShortenerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UrlShortenerController(val service: UrlShortenerService) {
    @PostMapping("/short-links")
    fun createShortUrl(@RequestBody body: CreateShortUrlRequest): ShortUrlResponse {
        val shortUrl = service.createShortURL(body.url)
        return ShortUrlResponse(shortUrlId = shortUrl.shortUrlId, url=shortUrl.url, createdAt = shortUrl.createdAt)
    }

    @GetMapping("/short-links/{shortUrlId}")
    fun getShortUrlByShortUrlId(@PathVariable shortUrlId: String): ShortUrlResponse {
        val shortUrl = service.getShortUrlByShortUrlId(shortUrlId)
        return ShortUrlResponse(shortUrlId = shortUrl.shortUrlId, url=shortUrl.url, createdAt = shortUrl.createdAt)
    }
}