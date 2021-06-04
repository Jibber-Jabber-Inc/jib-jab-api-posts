package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.domain.PostUserLike
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostLikeInfoDto
import com.jibberjabber.jibjab_posts.factory.PostCreateFactory
import com.jibberjabber.jibjab_posts.repository.PostRepository
import com.jibberjabber.jibjab_posts.repository.PostUserLikeRepository
import com.jibberjabber.jibjab_posts.utils.UserUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostServiceImpl(
    val postRepository: PostRepository,
    val postUserLikeRepository: PostUserLikeRepository,
    val userUtils: UserUtils,
    val postCreateFactory: PostCreateFactory
) : PostService {

    override fun getAllByFollowers(): List<Post> {
        return userUtils.getFollowedUsersById().flatMap { user -> getAllPostsByUserId(user.id) }.distinct()
    }

    override fun getAllPostsByUserId(userId: String): List<Post> {
        return postRepository.findAllByUserCreator(userId)
    }

    override fun createPost(postCreationDto: PostCreationDto): Post {
        val userInfo = userUtils.getTokenUserInformation()
        return postRepository.save(postCreateFactory.from(postCreationDto, userInfo.id))
    }

    override fun deletePost(id: String) {
        postRepository.deleteById(id);
    }

    override fun likePost(postId: String) {
        val userInfo = userUtils.getTokenUserInformation()
        val post = postRepository.findById(postId).orElseThrow()
        if (!postUserLikeRepository.existsByPostIdAndUserId(postId, userInfo.id))
            postUserLikeRepository.save(PostUserLike(post, userInfo.id))
    }

    override fun getPostLikeInfo(post: Post): PostLikeInfoDto {
        val userInfo = userUtils.getTokenUserInformation()
        val isLiked = postUserLikeRepository.existsByPostIdAndUserId(post.id!!, userInfo.id)
        val count = postUserLikeRepository.countByPostId(post.id!!)
        return PostLikeInfoDto(isLiked, count)
    }

    override fun dislikePost(postId: String) {
        val userInfo = userUtils.getTokenUserInformation()
        val optional: Optional<PostUserLike> = postUserLikeRepository.findFirstByPostIdAndUserId(postId, userInfo.id)
        optional.ifPresent { postUserLikeRepository.deleteById(optional.get().id!!) }
    }
}
