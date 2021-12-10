package com.coderbot.follower.data.api.response

import com.coderbot.follower.data.model.User
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse (
    @SerialName("data") var users: MutableList<User>,
)