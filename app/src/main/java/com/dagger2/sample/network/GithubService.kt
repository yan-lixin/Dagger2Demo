package com.dagger2.sample.network

import com.dagger2.sample.models.GithubRepo
import com.dagger2.sample.models.GithubUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
interface GithubService {
    @GET("users/{username}/repos")
    fun getReposForUser(@Path("username") username: String): Call<List<GithubRepo>>

    @GET("repositories")
    fun getAllRepos(): Call<List<GithubRepo>>

    @GET("users/{username}")
    fun getUser(@Path("username") username: String): Call<GithubUser>
}