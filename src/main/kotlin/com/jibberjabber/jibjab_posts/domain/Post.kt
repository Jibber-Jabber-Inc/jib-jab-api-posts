package com.jibberjabber.jibjab_posts.domain

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Table(name = "post")
@Entity
data class Post(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long?,

    var content: String,

    @CreationTimestamp
    var creationDate: LocalDateTime
)
