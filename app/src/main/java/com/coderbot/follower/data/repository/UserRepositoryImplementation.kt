package com.coderbot.follower.data.repository

import com.coderbot.follower.data.api.UserAPIs
import com.coderbot.follower.data.model.User
import com.coderbot.follower.domain.repository.UserRepository
import comcoderbotfollower.datamodel.DatabaseQueries

class UserRepositoryImplementation constructor(private val database: DatabaseQueries, private val userAPIs: UserAPIs) : UserRepository
{
    private var users = mutableListOf<User>()

    override fun getCachedUsers(): MutableList<User> = users

    override suspend fun getUsers(): MutableList<User>
    {
        users = userAPIs.getUsers()
        users.forEach {
            database.insertFullUserObject(comcoderbotfollower.datamodel.User(
                id = it.id.toLong(),
                email = it.email,
                first_name = it.firstName,
                last_name = it.lastName,
                avatar = it.avatar,
            ))
        }
        return users
    }

    override suspend fun getFollowedUsers(): MutableList<Long> = database.selectAllFollowerdUsers().executeAsList().toMutableList()

    override suspend fun followUsers(id: Int) = database.insertFollowedUser(id.toLong())

    override suspend fun unfollowUsers(id: Int) = database.removeFollowedUser(id.toLong())
}