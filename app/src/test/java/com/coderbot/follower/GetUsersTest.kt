package com.coderbot.follower

import com.coderbot.follower.data.model.User
import com.coderbot.follower.domain.repository.UserRepository
import com.coderbot.follower.domain.usecase.GetUsers
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetUsersTest
{
    private lateinit var getUsers: GetUsers
    private lateinit var repository: UserRepository
    private val followedUsers = mutableListOf<Long>(1, 3)
    private val users = mutableListOf(
        User(id = 0, email = "m@gmail.com", followed = false),
        User(id = 1, email = "s@gmail.com", followed = false),
        User(id = 2, email = "a@gmail.com", followed = false),
        User(id = 3, email = "w@gmail.com", followed = false),
    )

    @Before
    fun init()
    {
        repository = Mockito.mock(UserRepository::class.java)
        getUsers = GetUsers(repository)
    }

    @Test
    fun testGetUsersProcess()
    {
        runBlocking {
            Mockito.`when`(repository.getUsers()).thenReturn(users)
            Mockito.`when`(repository.getFollowedUsers()).thenReturn(followedUsers)

            val actualResult = getUsers.run()
            Assert.assertEquals(4, actualResult.size)
            Assert.assertEquals(true, actualResult[1].followed)
            Assert.assertEquals(true, actualResult[3].followed)
        }
    }
}