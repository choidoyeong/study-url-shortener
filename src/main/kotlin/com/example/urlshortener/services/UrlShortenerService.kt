package com.example.urlshortener.services

import com.example.urlshortener.models.ShortUrl
import com.example.urlshortener.repositories.ShortUrlRepository
import org.springframework.stereotype.Service
import java.nio.charset.Charset
import java.util.*

@Service
class UrlShortenerService(val repository: ShortUrlRepository) {
    fun createShortURL(url: String): ShortUrl {
        val shortUrlId = Base64.getUrlEncoder().encodeToString(url.toByteArray())

        val shortUrl = repository.findByShortUrlId(shortUrlId) ?: ShortUrl(
            url=url,
            shortUrlId=shortUrlId,
        )

        repository.save(shortUrl)
        return shortUrl
    }

    fun getShortUrlByShortUrlId(shortUrlId: String): ShortUrl? = repository.findByShortUrlId(shortUrlId)
}