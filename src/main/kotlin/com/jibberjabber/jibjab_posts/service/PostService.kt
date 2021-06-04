package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostLikeInfoDto

interface PostService {
    fun getAllByFollowers(): List<Post>
    fun getAllPostsByUserId(userId: String): List<Post>
    fun createPost(postCreationDto: PostCreationDto): Post
    fun deletePost(id: String)
    fun likePost(postId: String)
    fun dislikePost(postId: String)
    fun getPostLikeInfo(post: Post): PostLikeInfoDto
}