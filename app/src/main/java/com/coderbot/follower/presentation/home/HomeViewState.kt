package com.coderbot.follower.presentation.home

import com.coderbot.follower.data.model.User

sealed class HomeViewState
{
    object ViewInitializationState : HomeViewState()
    class DataState(val users: MutableList<User>) : HomeViewState()
    class ErrorState(val error: Throwable) : HomeViewState()
    object LoadingState : HomeViewState()
}