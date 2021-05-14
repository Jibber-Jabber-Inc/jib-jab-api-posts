package com.jibberjabber.jibjab_posts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.servlet.config.annotation.CorsRegistry

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@SpringBootApplication
@EnableJpaRepositories
@EnableScheduling
class JibjabPostsApplication

fun main(args: Array<String>) {
    runApplication<JibjabPostsApplication>(*args)
}

@Bean
fun corsConfigurer(): WebMvcConfigurer {
    return object : WebMvcConfigurer {
        override fun addCorsMappings(registry: CorsRegistry) {
            registry.addMapping("*").allowedOrigins("*").allowedHeaders("*")
        }
    }
}