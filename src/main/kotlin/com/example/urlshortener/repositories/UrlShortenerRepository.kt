package com.example.urlshortener.repositories

import com.example.urlshortener.models.UrlShortener
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlShortenerRepository : CrudRepository<UrlShortener, Long> {}
