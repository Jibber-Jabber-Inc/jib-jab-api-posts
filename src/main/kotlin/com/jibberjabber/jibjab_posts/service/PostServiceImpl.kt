package com.jibberjabber.jibjab_posts.service

import com.jibberjabber.jibjab_posts.domain.Post
import com.jibberjabber.jibjab_posts.domain.PostUserLike
import com.jibberjabber.jibjab_posts.domain.User
import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostLikeInfoDto
import com.jibberjabber.jibjab_posts.dto.UserInfoDto
import com.jibberjabber.jibjab_posts.factory.PostCreateFactory
import com.jibberjabber.jibjab_posts.repository.PostRepository
import com.jibberjabber.jibjab_posts.repository.PostUserLikeRepository
import com.jibberjabber.jibjab_posts.repository.UserRepository
import com.jibberjabber.jibjab_posts.utils.UserUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostServiceImpl(
    val postRepository: PostRepository,
    val postUserLikeRepository: PostUserLikeRepository,
    val userRepository: UserRepository,
    val userUtils: UserUtils,
    val postCreateFactory: PostCreateFactory
) : PostService {

    override fun getAllByFollowers(): List<Post> {
        return userUtils.getFollowedUsersById().flatMap { user ->  getAllPostsByUserId(user.id)}.distinct()
    }

    override fun getAllPostsByUserId(userId: String): List<Post> {
        return postRepository.findAllByUserCreatorId(userId)
    }

    override fun createPost(postCreationDto: PostCreationDto): Post {
        val userInfo = userUtils.getTokenUserInformation()
        return postRepository.save(postCreateFactory.from(postCreationDto, User(userInfo.id, userInfo.username)))
    }

    override fun deletePost(id: String) {
        postRepository.deleteById(id);
    }

    override fun likePost(postId: String) {
        val userInfo = userUtils.getTokenUserInformation()
        val post = postRepository.findById(postId).orElseThrow()
        val user = userRepository.findById(userInfo.id).orElseThrow()
        if (!postUserLikeRepository.existsByPostIdAndUserId(postId, user.id))
            postUserLikeRepository.save(PostUserLike(post, user))
    }

    override fun getPostLikeInfo(post: Post): PostLikeInfoDto {
        val userInfo: UserInfoDto = userUtils.getUserInfoFromId(post.userCreator.id)!!
        val isLiked = postUserLikeRepository.existsByPostIdAndUserId(post.id!!, userInfo.id)
        val count = postUserLikeRepository.countByPostId(post.id!!)
        return PostLikeInfoDto(isLiked, count)
    }

    override fun dislikePost(postId: String) {
        val userInfo = userUtils.getTokenUserInformation()
        val user = userRepository.findById(userInfo.id).orElseThrow()
        val optional: Optional<PostUserLike> = postUserLikeRepository.findFirstByPostIdAndUserId(postId, user.id)
        optional.ifPresent { postUserLikeRepository.deleteById(optional.get().id!!) }
    }
}
