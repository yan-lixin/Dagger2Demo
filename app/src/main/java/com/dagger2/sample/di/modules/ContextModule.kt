package com.dagger2.sample.di.modules

import android.content.Context
import com.dagger2.sample.di.annotation.AppContext
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
class ContextModule(context: Context) {

    private val context: Context = context.applicationContext

    @Provides
    @AppScope
    @AppContext
    fun context(): Context {
        return context
    }
}