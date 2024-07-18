package com.jsr_dev.jwtauth.controller

import com.jsr_dev.jwtauth.domain.model.auth.AuthMapper.mapToTokenResponse
import com.jsr_dev.jwtauth.domain.model.auth.AuthenticationRequest
import com.jsr_dev.jwtauth.domain.model.auth.AuthenticationResponse
import com.jsr_dev.jwtauth.domain.model.auth.RefreshTokenRequest
import com.jsr_dev.jwtauth.domain.model.auth.TokenResponse
import com.jsr_dev.jwtauth.service.AuthenticationService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authenticationService: AuthenticationService) {

    @PostMapping
    fun authenticate(@RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
        authenticationService.authentication(authRequest)

    @PostMapping("/refresh")
    fun refreshAccessToken(@RequestBody request: RefreshTokenRequest): TokenResponse =
        authenticationService.refreshAccessToken(request.token)
            ?. mapToTokenResponse()
            ?: throw ResponseStatusException(HttpStatus.FORBIDDEN, "Invalid refresh token.")
}