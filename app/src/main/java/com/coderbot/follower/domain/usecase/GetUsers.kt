package com.coderbot.follower.domain.usecase

import com.coderbot.follower.data.model.User
import com.coderbot.follower.domain.repository.UserRepository

class GetUsers constructor(private val repository: UserRepository)
{
    suspend fun run(): MutableList<User>
    {
        val users = repository.getUsers()
        val followedUsers = repository.getFollowedUsers()
        followedUsers.forEach {
            users.find { user -> user.id == it.toInt() }?.followed = true
        }
        return users
    }
}