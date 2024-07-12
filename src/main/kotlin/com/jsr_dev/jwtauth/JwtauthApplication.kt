package com.jsr_dev.jwtauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JwtauthApplication

fun main(args: Array<String>) {
	runApplication<JwtauthApplication>(*args)
}
