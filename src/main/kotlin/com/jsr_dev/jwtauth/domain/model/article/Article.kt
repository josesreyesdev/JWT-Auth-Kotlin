package com.jsr_dev.jwtauth.domain.model.article

import java.util.*

data class Article(
    val id: UUID,
    val title: String,
    val content: String
)
