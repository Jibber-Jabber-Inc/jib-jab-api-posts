package com.jibberjabber.jibjab_posts.dto

import java.time.LocalDateTime

data class PostDto(
    var id: String?,
    var content: String?,
    var userInfoDto: UserInfoDto?,
    var creationDate: LocalDateTime?
)

data class PostInfoDto(
    var id: String?,
    var content: String?,
    var userInfoDto: UserInfoDto?,
    var creationDate: LocalDateTime?,
    var isLiked: Boolean,
    var amountLikes: Long
)

data class PostLikeInfoDto(
    var isLiked: Boolean,
    var amountLikes: Long
)

data class PostCreationDto(
    var content: String
)