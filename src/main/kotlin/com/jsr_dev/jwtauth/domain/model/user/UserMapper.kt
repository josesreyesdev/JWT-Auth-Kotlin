package com.jsr_dev.jwtauth.domain.model.user

import java.util.*

object UserMapper {

    fun User.toResponse(): UserResponse =
        UserResponse(
            uuid = this.id,
            email = this.email
        )

    fun UserRequest.toModel(): User =
        User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER
        )

    fun UpdateData.toUser(user: User): User =
        user.copy(
            email = this.email ?: user.email,
            password = this.password ?: user.password
        )
}