package com.jibberjabber.jibjab_posts.factory

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostDto
import com.jibberjabber.jibjab_posts.dto.UserInfoDto
import com.jibberjabber.jibjab_posts.utils.UserUtils
import org.springframework.stereotype.Component

@Component
class PostFactory(
    private val userUtils: UserUtils
) : AbstractFactory<Post, PostDto> {

    override fun convert(input: Post): PostDto {
        val userInfo: UserInfoDto? = userUtils.getUserInfoFromId(input.userId)
        return PostDto(input.id, input.content, userInfo, input.creationDate)
    }

}


