package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto

interface PostService {
    fun getAll(): List<Post>
    fun createPost(postCreationDto: PostCreationDto): Post
}