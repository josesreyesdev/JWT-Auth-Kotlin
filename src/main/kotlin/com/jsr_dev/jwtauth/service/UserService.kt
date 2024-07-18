package com.jsr_dev.jwtauth.service

import com.jsr_dev.jwtauth.domain.model.user.UpdateData
import com.jsr_dev.jwtauth.domain.model.user.User
import com.jsr_dev.jwtauth.respository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(private val userRepository: UserRepository) {

    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if (found == null)  {
            userRepository.save(user)
            user
        } else null
    }

    fun findByUUID(uuid: UUID): User? = userRepository.findByUUID(uuid)

    fun findAll(): List<User> = userRepository.findAll().toList()

    fun updateUser(updateData: UpdateData): User? = userRepository.updateUser(updateData)

    fun deleteByUUID(uuid: UUID): Boolean = userRepository.deleteByUUID(uuid)
}