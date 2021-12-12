package com.coderbot.follower

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    GetUsersTest::class,
    FollowUnfollowUserTest::class
)
class Main