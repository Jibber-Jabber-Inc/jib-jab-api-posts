package com.jibberjabber.jibjab_posts.dto

data class UserInfoDto(
    var id: String,
    var username: String,
    var email: String,
    var firstName: String,
    var lastName: String,
    var role: String?
)

data class UserInfoDtoList(
    var userInfoDto: List<UserInfoDto>
)