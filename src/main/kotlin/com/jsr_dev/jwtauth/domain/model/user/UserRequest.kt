package com.jsr_dev.jwtauth.domain.model.user

data class UserRequest(
    val email: String,
    val password: String
)
