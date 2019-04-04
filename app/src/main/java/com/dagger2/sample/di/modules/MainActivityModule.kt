package com.dagger2.sample.di.modules

import com.dagger2.sample.di.annotation.MainActivityScope
import com.dagger2.sample.ui.MainActivity
import dagger.Module
import dagger.Provides

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun mainActivity(): MainActivity {
        return mainActivity
    }
}