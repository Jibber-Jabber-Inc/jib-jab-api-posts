package com.jibberjabber.jibjab_posts.dto

import java.time.LocalDateTime

data class PostDto(
    var id: Long?,
    var description: String,
    var creationDate: LocalDateTime
)

data class PostCreationDto(
    var description: String
)