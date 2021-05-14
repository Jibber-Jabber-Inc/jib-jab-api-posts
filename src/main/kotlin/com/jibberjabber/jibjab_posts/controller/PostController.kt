package com.jibberjabber.jibjab_posts.controller

import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostDto
import com.jibberjabber.jibjab_posts.factory.PostFactory
import com.jibberjabber.jibjab_posts.service.PostService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController(
    val postService: PostService
) {
    private val postFactory: PostFactory = PostFactory()

    @GetMapping("")
    fun getPosts(): List<PostDto> {
        return postService.getAll().map { post -> postFactory.convert(post) }
    }

    @PostMapping("/create")
    fun createProperty(@RequestBody postCreationDto: PostCreationDto): PostDto {
        val createPost = postService.createPost(postCreationDto)
        return postFactory.convert(createPost)
    }

}