package com.jibberjabber.jibjab_posts.controller

import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.dto.PostDto
import com.jibberjabber.jibjab_posts.factory.PostFactory
import com.jibberjabber.jibjab_posts.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/post")
class PostController @Autowired constructor(
    val postService: PostService,
    val postFactory: PostFactory
) {

    @GetMapping
    fun getPosts(): List<PostDto> {
        return postService.getAll().map { post -> postFactory.convert(post) }
    }

    @PostMapping("/create")
    fun createPost(@RequestBody postCreationDto: PostCreationDto): PostDto {
        return postFactory.convert(postService.createPost(postCreationDto))
    }

}