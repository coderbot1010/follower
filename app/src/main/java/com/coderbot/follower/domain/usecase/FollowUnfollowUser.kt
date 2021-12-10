package com.coderbot.follower.domain.usecase

import com.coderbot.follower.data.model.User
import com.coderbot.follower.domain.repository.UserRepository

class FollowUnfollowUser constructor(private val repository: UserRepository)
{
    suspend fun run(id: Int): MutableList<User>
    {
        val users = repository.getCachedUsers()
        users.forEach { user ->
            if (user.id == id)
            {
                if (user.followed) repository.unfollowUsers(id)
                else repository.followUsers(id)
                user.followed = !user.followed
            }
        }
        return users
    }
}