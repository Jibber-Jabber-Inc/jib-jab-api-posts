package com.jibberjabber.jibjab_posts.factory

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostDto
import com.jibberjabber.jibjab_posts.dto.PostInfoDto
import com.jibberjabber.jibjab_posts.dto.PostLikeInfoDto
import com.jibberjabber.jibjab_posts.dto.UserInfoDto
import com.jibberjabber.jibjab_posts.service.PostService
import com.jibberjabber.jibjab_posts.utils.UserUtils
import org.springframework.stereotype.Component

@Component
class PostFactory(
    private val userUtils: UserUtils
) : AbstractFactory<Post, PostDto> {

    override fun convert(input: Post): PostDto {
        val userInfo: UserInfoDto? = userUtils.getUserInfoFromId(input.userCreator)
        return PostDto(input.id, input.content, userInfo, input.creationDate)
    }

}

@Component
class PostInfoFactory(
    private val userUtils: UserUtils,
    private val postService: PostService
) : AbstractFactory<Post, PostInfoDto> {

    override fun convert(input: Post): PostInfoDto {
        val userInfo: UserInfoDto? = userUtils.getUserInfoFromId(input.userCreator)
        val postLikeInfo: PostLikeInfoDto = postService.getPostLikeInfo(input)
        return PostInfoDto(input.id, input.content, userInfo, input.creationDate, postLikeInfo.isLiked, postLikeInfo.amountLikes)
    }

}

