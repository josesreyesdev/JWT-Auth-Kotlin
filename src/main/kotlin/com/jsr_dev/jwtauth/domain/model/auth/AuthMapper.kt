package com.jsr_dev.jwtauth.domain.model.auth

object AuthMapper {

    fun String.mapToTokenResponse(): TokenResponse = TokenResponse(token = this)

}