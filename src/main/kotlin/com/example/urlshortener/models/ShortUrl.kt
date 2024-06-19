package com.example.urlshortener.models

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import java.time.ZonedDateTime

@Entity
@Table(name = "short_url")
data class ShortUrl(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val url: String,

    @Column(unique = true, nullable = false)
    var shortUrlId: String,

    @Column(nullable = false, columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @CreatedDate
    val createdAt: ZonedDateTime = ZonedDateTime.now(),
)

