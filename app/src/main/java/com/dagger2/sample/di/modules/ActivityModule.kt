package com.dagger2.sample.di.modules

import android.app.Activity
import android.content.Context
import com.dagger2.sample.di.annotation.ActivityContext
import com.dagger2.sample.di.annotation.AppScope
import dagger.Module
import dagger.Provides

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@Module
class ActivityModule(private val context: Activity) {

    @Provides
    @AppScope
    @ActivityContext
    fun context(): Context {
        return context
    }
}