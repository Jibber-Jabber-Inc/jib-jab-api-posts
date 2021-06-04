package com.jibberjabber.jibjab_posts.domain

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table(name = "post")
@Entity
class Post(
    var content: String,
    @ManyToOne(cascade = [CascadeType.ALL])
    var userCreator: User,
    @CreationTimestamp
    var creationDate: LocalDateTime,
) : AbstractEntity()

@Table(name = "post_user_like")
@Entity
class PostUserLike(
    @ManyToOne
    var post: Post,
    @ManyToOne(cascade = [CascadeType.ALL])
    var user: User
) : AbstractEntity()

@Table(name = "user_data")
@Entity
class User(
    override var id: String,
    var userName: String
) : AbstractEntityId(id)