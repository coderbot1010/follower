package com.coderbot.follower.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class User (
    @SerialName("id") var id: Int = 0,
    @SerialName("email") var email: String = "",
    @SerialName("first_name") var firstName: String = "",
    @SerialName("last_name") var lastName: String = "",
    @SerialName("name") var name: String = "",
    @SerialName("job") var job: String = "",
    @SerialName("avatar") var avatar: String = "",
    @Transient var followed: Boolean = false,
)