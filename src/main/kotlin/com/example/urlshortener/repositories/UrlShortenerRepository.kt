package com.example.urlshortener.repositories

import com.example.urlshortener.models.ShortUrl
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ShortUrlRepository : CrudRepository<ShortUrl, Long> {
    fun findByShortUrlId(shortUrlId: String): ShortUrl?
}
