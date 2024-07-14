package com.jsr_dev.jwtauth.controller

import com.jsr_dev.jwtauth.domain.model.user.updateData
import com.jsr_dev.jwtauth.domain.model.user.UserRequest
import com.jsr_dev.jwtauth.domain.model.user.UserResponse
import com.jsr_dev.jwtauth.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.UUID

@RestController
@RequestMapping("/api/user")
class UserController(private val userService: UserService) {

    @PostMapping
    fun createUser(@RequestBody userRequest: UserRequest): UserResponse =
        userService.createUser(userRequest.toModel())
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create user.")

    @GetMapping
    fun listAll(): List<UserResponse> =
        userService.findAll().map { it.toResponse() }

    @GetMapping("/{uuid}")
    fun findByUUID(@PathVariable uuid: UUID): UserResponse =
        userService.findByUUID(uuid)
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")

    @PutMapping
    fun updateByUUID(@RequestBody updateData: updateData): UserResponse =
        userService.updateUser(updateData)
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")


    @DeleteMapping("/{uuid}")
    fun deleteByUUID(@PathVariable uuid: UUID): ResponseEntity<Boolean> {
        val success = userService.deleteByUUID(uuid)

        return if (success) {
            ResponseEntity.noContent().build()
        } else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.")
    }

}


