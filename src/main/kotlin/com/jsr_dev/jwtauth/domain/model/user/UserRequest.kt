package com.jsr_dev.jwtauth.domain.model.user

import java.util.*

data class UserRequest(
    val email: String,
    val password: String
) {
    fun toModel(): User {
        return User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER
        )
    }
}
