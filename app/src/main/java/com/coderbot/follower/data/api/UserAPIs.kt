package com.coderbot.follower.data.api

import com.coderbot.follower.BuildConfig
import com.coderbot.follower.data.api.response.BaseResponse
import com.coderbot.follower.data.model.User
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class UserAPIs constructor(private val httpClient: HttpClient)
{
    suspend fun getUsers() = httpClient.get<BaseResponse>("${BuildConfig.BASE_URL}/users").users

    suspend fun getUser(id: String) = httpClient.request<User>("${BuildConfig.BASE_URL}/users/$id") {
        method = HttpMethod.Get
    }

    suspend fun addUser(name: String, job: String) = httpClient.post<User>("${BuildConfig.BASE_URL}/users") {
        contentType(ContentType.Application.Json)
        body = User(name = name, job = job)
    }
}