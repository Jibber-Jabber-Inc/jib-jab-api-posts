package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.UserInfoDto
import com.jibberjabber.jibjab_posts.factory.PostCreateFactory
import com.jibberjabber.jibjab_posts.repository.PostRepository
import com.jibberjabber.jibjab_posts.utils.UserUtils
import org.springframework.stereotype.Service

@Service
class PostServiceImpl(
    val postRepository: PostRepository,
    val userUtils: UserUtils
) : PostService {

    val postCreateFactory: PostCreateFactory = PostCreateFactory()

    override fun getAll(): List<Post> {
        return postRepository.findAll()
    }

    override fun createPost(postCreationDto: PostCreationDto): Post {
        val userInfo: UserInfoDto = userUtils.getTokenUserInformation()
        return postRepository.save(postCreateFactory.from(postCreationDto, userInfo.userId))
    }
}
