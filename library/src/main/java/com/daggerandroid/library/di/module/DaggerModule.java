package com.daggerandroid.library.di.module;

import android.app.Application;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
@Module
public class DaggerModule {
    private final Application mApplication;

    public DaggerModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return this.mApplication;
    }
}
