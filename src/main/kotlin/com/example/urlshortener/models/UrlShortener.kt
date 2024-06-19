package com.example.urlshortener.models

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "url_shortener")
data class UrlShortener(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val url: String,

    @Column(unique = true, nullable = false)
    val shortUrlId: String,

    @Column(nullable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),
)

