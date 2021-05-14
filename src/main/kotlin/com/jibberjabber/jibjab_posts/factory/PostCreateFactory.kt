package com.jibberjabber.jibjab_posts.factory

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import java.time.LocalDateTime

class PostCreateFactory : AbstractFactory<Post, PostCreationDto> {

    override fun convert(input: Post): PostCreationDto {
        return PostCreationDto(input.description)
    }

    fun from(input: PostCreationDto): Post {
        return Post(null, input.description, LocalDateTime.now())
    }

}