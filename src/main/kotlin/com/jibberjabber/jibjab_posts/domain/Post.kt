package com.jibberjabber.jibjab_posts.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "post")
@Entity
class Post(
    var content: String,
    var userId: String,
    @CreationTimestamp
    var creationDate: LocalDateTime
) : AbstractEntity()