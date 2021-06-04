package com.jibberjabber.jibjab_posts.domain

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "post")
@Entity
class Post(
    var content: String,
    var userCreator: String,
    @CreationTimestamp
    var creationDate: LocalDateTime,
) : AbstractEntity()

@Table(name = "post_user_like")
@Entity
class PostUserLike(
    @ManyToOne
    var post: Post,
    var userId: String
) : AbstractEntity()
