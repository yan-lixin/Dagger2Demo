package com.dagger2.sample

import android.app.Activity
import android.app.Application
import com.dagger2.sample.di.component.AppComponent
import com.dagger2.sample.di.component.DaggerAppComponent
import com.dagger2.sample.di.modules.ContextModule
import timber.log.Timber

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
class App: Application() {

    var component: AppComponent? = null

    companion object {
        fun get(activity: Activity): App {
            return activity.application as App
        }
    }

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        component = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }
}