package com.jsr_dev.jwtauth.respository

import com.jsr_dev.jwtauth.domain.model.user.Role
import com.jsr_dev.jwtauth.domain.model.user.UpdateData
import com.jsr_dev.jwtauth.domain.model.user.User
import com.jsr_dev.jwtauth.domain.model.user.UserMapper.toUser
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository(private val encoder: PasswordEncoder) {

    private val users = mutableSetOf(
        User(
            id = UUID.randomUUID(),
            email = "email-1@gmail.com",
            password = encoder.encode("pass1"),
            role = Role.USER,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-2@gmail.com",
            password = encoder.encode("pass2"),
            role = Role.ADMIN,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-3@gmail.com",
            password = encoder.encode("pass3"),
            role = Role.USER,
        ),
    )

    fun save(user: User): Boolean {
        val updated: User = passwordEncoder(user)

        return users.add(updated)
    }

    fun findByEmail(email: String): User? =
        users.firstOrNull { it.email == email }

    fun findAll(): Set<User> = users

    fun findByUUID(uuid: UUID): User? =
        users.firstOrNull { it.id == uuid }

    fun deleteByUUID(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)

        return foundUser?.let {
            users.removeIf { it.id == uuid }
        } ?: false
    }

    fun updateUser(updateData: UpdateData): User? {
        val userToUpdate: User? = findByUUID(updateData.id)

        userToUpdate?.let { user ->
            users.remove(user)

            val update = updateData.toUser(user)

            val updatedUser = passwordEncoder(update)

            users.add(updatedUser)
            return updatedUser
        }

        return null
    }

    fun passwordEncoder(user: User): User =
        user.copy(password = encoder.encode(user.password))
}