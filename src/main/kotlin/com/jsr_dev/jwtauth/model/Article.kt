package com.jsr_dev.jwtauth.model

import java.util.*

data class Article(
    val id: UUID,
    val title: String,
    val content: String
)
