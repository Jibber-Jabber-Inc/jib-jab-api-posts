package com.jibberjabber.jibjab_posts.repository

import com.jibberjabber.jibjab_posts.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository : JpaRepository<Post, String> {

    fun findAllByUserCreator(userCreatorId: String): List<Post>

}