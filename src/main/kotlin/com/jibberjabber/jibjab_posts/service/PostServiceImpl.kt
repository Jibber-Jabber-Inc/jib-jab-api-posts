package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.factory.PostCreateFactory
import com.jibberjabber.jibjab_posts.repository.PostRepository
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    val postRepository: PostRepository,
) : PostService {

    val postCreateFactory: PostCreateFactory = PostCreateFactory()

    override fun getAll(): List<Post> {
        return postRepository.findAll()
    }

    override fun createPost(postCreationDto: PostCreationDto): Post {
        return postRepository.save(postCreateFactory.from(postCreationDto))
    }
}
