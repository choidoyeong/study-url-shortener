package com.example.urlshortener.controllers.responses

import java.time.ZonedDateTime

data class ShortUrlResponse(
    val shortUrlId: String,
    val url: String,
    val createdAt: ZonedDateTime
)
