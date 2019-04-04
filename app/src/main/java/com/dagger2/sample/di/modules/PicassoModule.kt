package com.dagger2.sample.di.modules

import android.content.Context
import com.dagger2.sample.di.annotation.AppContext
import com.dagger2.sample.di.annotation.AppScope
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@Module(includes = [ContextModule::class, NetworkModule::class])
class PicassoModule {

    @Provides
    @AppScope
    fun picasso(@AppContext context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
            .downloader(okHttp3Downloader)
            .build()
    }

    @Provides
    @AppScope
    fun okHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }
}