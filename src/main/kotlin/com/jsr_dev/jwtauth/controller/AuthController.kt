package com.jsr_dev.jwtauth.controller

import com.jsr_dev.jwtauth.domain.model.auth.AuthenticationRequest
import com.jsr_dev.jwtauth.domain.model.auth.AuthenticationResponse
import com.jsr_dev.jwtauth.service.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(private val authenticationService: AuthenticationService) {

    @PostMapping
    fun authenticate(@RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
        authenticationService.authentication(authRequest)
}