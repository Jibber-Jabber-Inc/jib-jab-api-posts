package com.jibberjabber.jibjab_posts.controller

import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostDto
import com.jibberjabber.jibjab_posts.dto.PostInfoDto
import com.jibberjabber.jibjab_posts.factory.PostFactory
import com.jibberjabber.jibjab_posts.factory.PostInfoFactory
import com.jibberjabber.jibjab_posts.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/posts")
class PostController @Autowired constructor(
    val postService: PostService,
    val postFactory: PostFactory,
    val postInfoFactory: PostInfoFactory
) {

    @GetMapping
    fun getPosts(): List<PostInfoDto> {
        return postService.getAll().map { post -> postInfoFactory.convert(post) }
    }

    @PostMapping("/create")
    fun createPost(@RequestBody postCreationDto: PostCreationDto): PostDto {
        return postFactory.convert(postService.createPost(postCreationDto))
    }

    @DeleteMapping("/{id}")
    fun deletePost(@PathVariable("id") id: String) {
        postService.deletePost(id)
    }

    @PostMapping("/like/{postId}")
    fun likePost(@PathVariable("postId") postId: String) {
         postService.likePost(postId)
    }

    @PostMapping("/dislike/{postId}")
    fun dislikePost(@PathVariable("postId") postId: String) {
        postService.dislikePost(postId)
    }

}