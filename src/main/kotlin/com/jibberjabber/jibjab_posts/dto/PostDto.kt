package com.jibberjabber.jibjab_posts.dto

import java.time.LocalDateTime

data class PostDto(
    var id: Long?,
    var content: String,
    var creationDate: LocalDateTime
)

data class PostCreationDto(
    var content: String
)