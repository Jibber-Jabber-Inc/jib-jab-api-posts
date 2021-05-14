package com.jibberjabber.jibjab_posts.post

import com.jibberjabber.jibjab_posts.dto.PostCreationDto
import com.jibberjabber.jibjab_posts.service.PostService
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class PostTest(
    @Autowired
    val postService: PostService
) {

    @Test
    fun test001_runTest() {
        val postCreationDto = PostCreationDto("First jib");
        val createdPost = postService.createPost(postCreationDto)
        assertThat(createdPost.content).isEqualTo(postCreationDto.content)
    }

}