package com.jsr_dev.jwtauth.controller

import java.util.*

data class ArticleResponse(
    val id: UUID,
    val title: String,
    val content: String
)
