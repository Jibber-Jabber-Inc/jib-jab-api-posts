package com.jibberjabber.jibjab_posts.factory

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostDto

class PostFactory : AbstractFactory<Post, PostDto> {

    override fun convert(input: Post): PostDto {
        return PostDto(input.id, input.content, input.creationDate)
    }

    fun from(input: PostDto): Post {
        return Post(input.id, input.content, input.creationDate)
    }

}


