package com.dagger2.sample.di.modules

import android.content.Context
import com.dagger2.sample.di.annotation.AppContext
import com.dagger2.sample.di.annotation.AppScope
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@Module(includes = [ContextModule::class])
class NetworkModule {

    @Provides
    @AppScope
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    @AppScope
    fun cache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1024 * 1024)
    }

    @Provides
    @AppScope
    fun cacheFile(@AppContext context: Context): File {
        return File(context.cacheDir, "okhttp_cache")
    }

    @Provides
    @AppScope
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .cache(cache)
            .build()
    }
}