package com.coderbot.follower.presentation.home

sealed class HomeViewIntents
{
    object GetUsers : HomeViewIntents()
    class ToggleUser(val id: Int) : HomeViewIntents()
}