package com.jibberjabber.jibjab_posts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter


@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@EnableJpaRepositories
@EnableScheduling
class JibjabPostsApplication

fun main(args: Array<String>) {
    runApplication<JibjabPostsApplication>(*args)
}

@Bean
fun corsFilter(): CorsFilter {
    val source = UrlBasedCorsConfigurationSource()
    val configuration = CorsConfiguration()
    configuration.allowCredentials = true
    configuration.addAllowedOrigin("*")
    configuration.addAllowedHeader("*")
    configuration.addAllowedMethod("*")
    source.registerCorsConfiguration("/**", configuration)
    return CorsFilter(source)
}