package com.coderbot.follower.domain.repository

import com.coderbot.follower.data.model.User

interface UserRepository
{
    fun getCachedUsers(): MutableList<User>

    suspend fun getUsers(): MutableList<User>

    suspend fun getFollowedUsers(): MutableList<Long>

    suspend fun followUser(id: Int)

    suspend fun unfollowUser(id: Int)
}