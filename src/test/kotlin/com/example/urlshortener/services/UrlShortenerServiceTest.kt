package com.example.urlshortener.services

import com.example.urlshortener.models.ShortUrl
import com.example.urlshortener.repositories.ShortUrlRepository
import io.mockk.Called
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.util.*

class UrlShortenerServiceTest {
    val repository = mockk<ShortUrlRepository>()
    val service = UrlShortenerService(repository)

    @Test
    fun createShortURL() {
        every { repository.findByUrl(any()) } returns null
        every { repository.save(any()) } returns ShortUrl(1, "http://example.com", "123")

        val result = service.createShortURL("http://example.com")
        verify { repository.findByUrl("http://example.com") }
        verify(exactly = 2) { repository.save(any()) }
        assertEquals("http://example.com", result.url)
        assertEquals(Base64.getUrlEncoder().encodeToString("1".toByteArray()), result.shortUrlId)
    }

    @Test
    fun createShortUrlAlreadyExistUrl() {
        every { repository.findByUrl(any()) } returns ShortUrl(1, "http://example.com", "1234")

        val result = service.createShortURL("http://example.com")

        verify { repository.findByUrl("http://example.com") }
        verify { repository.save(any()) wasNot Called }
        assertEquals("http://example.com", result.url)
        assertEquals("1234", result.shortUrlId)
    }

    @Test
    fun getShortUrlByShortUrlId() {
    }
}