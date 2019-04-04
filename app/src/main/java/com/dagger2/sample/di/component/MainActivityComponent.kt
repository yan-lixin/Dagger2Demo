package com.dagger2.sample.di.component

import com.dagger2.sample.di.annotation.MainActivityScope
import com.dagger2.sample.di.modules.MainActivityModule
import com.dagger2.sample.ui.MainActivity
import dagger.Component

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@MainActivityScope
@Component(modules = [MainActivityModule::class], dependencies = [AppComponent::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}