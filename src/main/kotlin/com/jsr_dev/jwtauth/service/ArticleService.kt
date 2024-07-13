package com.jsr_dev.jwtauth.service

import com.jsr_dev.jwtauth.model.Article
import com.jsr_dev.jwtauth.respository.ArticleRepository
import org.springframework.stereotype.Service

@Service
class ArticleService(private val articleRepository: ArticleRepository) {

    fun findAll(): List<Article> = articleRepository.findAll()
}