package com.jsr_dev.jwtauth.domain.model.user

import java.util.*

data class User(
    val id: UUID,
    val email: String,
    val password: String,
    val role: Role
) {
    fun toResponse(): UserResponse {
        return UserResponse(
            uuid = this.id,
            email = this.email
        )
    }
}
