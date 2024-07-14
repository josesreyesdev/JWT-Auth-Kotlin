package com.jsr_dev.jwtauth.respository

import com.jsr_dev.jwtauth.domain.model.user.Role
import com.jsr_dev.jwtauth.domain.model.user.updateData
import com.jsr_dev.jwtauth.domain.model.user.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {

    private val users = mutableSetOf(
        User(
            id = UUID.randomUUID(),
            email = "email-1@gmail.com",
            password = "pass1",
            role = Role.USER,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-2@gmail.com",
            password = "pass2",
            role = Role.ADMIN,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-3@gmail.com",
            password = "pass3",
            role = Role.USER,
        ),
    )

    fun save(user: User): Boolean =
        users.add(user)

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

    fun updateUser(updateData: updateData): User? {
        val userToUpdate = users.firstOrNull { it.id == updateData.id }

        userToUpdate?.let {
            users.remove(it)

            val updatedUser = it.copy(
                email = updateData.email ?: it.email,
                password = updateData.password ?: it.password
            )

            users.add(updatedUser)
            return updatedUser
        }
        return null
    }
}