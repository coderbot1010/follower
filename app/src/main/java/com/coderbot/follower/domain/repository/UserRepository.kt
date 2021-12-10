package com.coderbot.follower.domain.repository

import com.coderbot.follower.data.model.User

interface UserRepository
{
    fun getCachedUsers(): MutableList<User>

    suspend fun getUsers(): MutableList<User>

    suspend fun getFollowedUsers(): MutableList<Long>

    suspend fun followUsers(id: Int)

    suspend fun unfollowUsers(id: Int)
}