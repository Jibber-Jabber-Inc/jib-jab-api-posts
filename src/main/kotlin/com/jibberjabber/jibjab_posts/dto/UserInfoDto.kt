package com.jibberjabber.jibjab_posts.dto

data class UserInfoDto(
    var userId: String?,
    var username: String,
    var email: String,
    var firstName: String,
    var lastName: String,
    var role: String?
)