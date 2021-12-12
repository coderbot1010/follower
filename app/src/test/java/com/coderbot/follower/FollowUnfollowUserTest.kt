package com.coderbot.follower

import com.coderbot.follower.data.model.User
import com.coderbot.follower.domain.repository.UserRepository
import com.coderbot.follower.domain.usecase.FollowUnfollowUser
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class FollowUnfollowUserTest
{
    private lateinit var followUnfollowUser: FollowUnfollowUser
    private lateinit var repository: UserRepository
    private val users = mutableListOf(
        User(id = 0, email = "m@gmail.com", followed = false),
        User(id = 1, email = "s@gmail.com", followed = false),
        User(id = 2, email = "a@gmail.com", followed = false),
        User(id = 3, email = "w@gmail.com", followed = true),
    )

    @Before
    fun init()
    {
        repository = Mockito.mock(UserRepository::class.java)
        Mockito.`when`(repository.getCachedUsers()).thenReturn(users)
        followUnfollowUser = FollowUnfollowUser(repository)
    }

    @Test
    fun testFollowingProcess()
    {
        runBlocking {
            val actualResult = followUnfollowUser.run(2)
            Assert.assertEquals(true, actualResult[2].followed)
        }
    }

    @Test
    fun testUnfollowingProcess()
    {
        runBlocking {
            val actualResult = followUnfollowUser.run(3)
            Assert.assertEquals(false, actualResult[3].followed)
        }
    }
}