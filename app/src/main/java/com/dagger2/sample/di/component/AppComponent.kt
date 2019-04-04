package com.dagger2.sample.di.component

import com.dagger2.sample.di.annotation.AppScope
import com.dagger2.sample.di.modules.ActivityModule
import com.dagger2.sample.di.modules.GithubServiceModule
import com.dagger2.sample.di.modules.PicassoModule
import com.dagger2.sample.network.GithubService
import com.squareup.picasso.Picasso
import dagger.Component

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@AppScope
@Component(modules = [GithubServiceModule::class, PicassoModule::class, ActivityModule::class])
interface AppComponent {
    fun getPicasso(): Picasso

    fun getGithubService(): GithubService
}