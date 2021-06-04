package com.jibberjabber.jibjab_posts.repository

import com.jibberjabber.jibjab_posts.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>