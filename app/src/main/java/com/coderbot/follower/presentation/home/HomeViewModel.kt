package com.coderbot.follower.presentation.home

import com.coderbot.follower.domain.usecase.FollowUnfollowUser
import com.coderbot.follower.domain.usecase.GetUsers
import com.coderbot.follower.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val getUsers: GetUsers, private val followUnfollowUser: FollowUnfollowUser) : BaseViewModel<HomeViewState, HomeViewIntents>()
{
    init
    {
        observeIntents {
            when (it)
            {
                is HomeViewIntents.GetUsers -> getUsers()
                is HomeViewIntents.ToggleUser -> toggleUser(it.id)
            }
        }
    }

    private fun getUsers() = CoroutineScope(Dispatchers.IO).launch {
        state.postValue(HomeViewState.LoadingState)
        try
        {
            state.postValue(HomeViewState.DataState(getUsers.run()))
        }
        catch (ex: Throwable)
        {
            ex.printStackTrace()
            state.postValue(HomeViewState.ErrorState(ex))
        }
    }

    private fun toggleUser(id: Int) = CoroutineScope(Dispatchers.IO).launch {
        try
        {
            state.postValue(HomeViewState.DataState(followUnfollowUser.run(id)))
        }
        catch (ex: Throwable)
        {
            ex.printStackTrace()
            state.postValue(HomeViewState.ErrorState(ex))
        }
    }
}