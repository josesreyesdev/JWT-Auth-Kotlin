package com.jsr_dev.jwtauth.domain.model.user

import java.util.UUID

data class updateData(
    val id: UUID,
    val email: String?,
    val password: String?
)
