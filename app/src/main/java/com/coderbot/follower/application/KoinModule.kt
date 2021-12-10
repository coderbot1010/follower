package com.coderbot.follower.application

import android.content.Context
import com.coderbot.follower.Database
import com.coderbot.follower.data.api.UserAPIs
import com.coderbot.follower.data.repository.UserRepositoryImplementation
import com.coderbot.follower.domain.repository.UserRepository
import com.coderbot.follower.domain.usecase.*
import com.coderbot.follower.presentation.home.HomeViewModel
import com.squareup.sqldelight.android.AndroidSqliteDriver
import comcoderbotfollower.datamodel.DatabaseQueries
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {

    single { provideHttpClient() }

    single { provideDatabase(get()) }

    single { UserAPIs(get()) }

    single { UserRepositoryImplementation(get(), get()) as UserRepository }

    single { GetUsers(get()) }

    single { FollowUnfollowUser(get()) }

    viewModel { HomeViewModel(get(), get()) }
}

private fun provideHttpClient() = HttpClient(OkHttp) {
    engine {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        addInterceptor(loggingInterceptor)
    }
    install(JsonFeature) {
        serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
            ignoreUnknownKeys = true
        })
    }
}

private fun provideDatabase(context: Context): DatabaseQueries = Database(AndroidSqliteDriver(Database.Schema, context, "database.db")).databaseQueries