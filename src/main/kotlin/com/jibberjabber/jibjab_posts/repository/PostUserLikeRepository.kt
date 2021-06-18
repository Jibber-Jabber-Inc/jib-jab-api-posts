package com.jibberjabber.jibjab_posts.repository

import com.jibberjabber.jibjab_posts.domain.PostUserLike
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*
import javax.transaction.Transactional

@Repository
interface PostUserLikeRepository : JpaRepository<PostUserLike, String> {

    fun existsByPostIdAndUserId(postId: String, userId: String): Boolean

    fun findFirstByPostIdAndUserId(postId: String, userId: String): Optional<PostUserLike>

    fun countByPostId(postId: String): Long

    @Transactional
    fun deleteAllByPostId(id: String)
}