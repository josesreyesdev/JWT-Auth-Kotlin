package com.jsr_dev.jwtauth.domain.model.user

import java.util.UUID

data class UserResponse(
    val uuid: UUID,
    val email: String
)
