package com.example.urlshortener.services

import com.example.urlshortener.models.ShortUrl
import com.example.urlshortener.repositories.ShortUrlRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UrlShortenerService(val repository: ShortUrlRepository) {
    fun createShortURL(url: String): ShortUrl = repository.findByUrl(url) ?: _createNewShortURL(url)

    fun _createNewShortURL(url: String): ShortUrl {
        var shortUrl = repository.save(ShortUrl(
            url=url,
            shortUrlId=Base64.getUrlEncoder().encodeToString(url.toByteArray()),
        ))

        shortUrl.shortUrlId = Base64.getUrlEncoder().encodeToString(shortUrl.id.toString().toByteArray())

        repository.save(shortUrl)
        return shortUrl
    }

    fun getShortUrlByShortUrlId(shortUrlId: String): ShortUrl? = repository.findByShortUrlId(shortUrlId)
}