package com.jsr_dev.jwtauth.domain.model.auth

data class AuthenticationRequest(
    val email: String,
    val password: String,
)
