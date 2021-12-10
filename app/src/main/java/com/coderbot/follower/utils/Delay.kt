package com.coderbot.follower.utils

import kotlinx.coroutines.*

object Delay
{
    fun run(duration: Long, action: () -> Unit){
        runBlocking {
            delay(duration)
            action()
        }
    }
}