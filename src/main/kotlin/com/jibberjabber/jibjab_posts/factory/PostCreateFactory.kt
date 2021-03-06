package com.jibberjabber.jibjab_posts.factory

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PostCreateFactory : AbstractFactory<Post, PostCreationDto> {

    override fun convert(input: Post): PostCreationDto {
        return PostCreationDto(input.content)
    }

    fun from(input: PostCreationDto, userId: String): Post {
        return Post(input.content, userId, LocalDateTime.now())
    }

}