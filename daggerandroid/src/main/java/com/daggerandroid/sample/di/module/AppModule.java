package com.daggerandroid.sample.di.module;

import android.app.Application;
import dagger.Module;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
@Module
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }
}
