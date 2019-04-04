package com.dagger2.sample.di.modules

import com.dagger2.sample.di.annotation.AppScope
import com.dagger2.sample.network.DateTimeConverter
import com.dagger2.sample.network.GithubService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import org.joda.time.DateTime
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@Module(includes = [NetworkModule::class])
class GithubServiceModule {

    @Provides
    @AppScope
    fun githubService(retrofit: Retrofit): GithubService {
        return retrofit.create(GithubService::class.java)
    }

    @Provides
    @AppScope
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeConverter())
        return gsonBuilder.create()
    }

    @Provides
    @AppScope
    fun retrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl("https://api.github.com")
            .build()
    }
}