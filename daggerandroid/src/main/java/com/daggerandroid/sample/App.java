package com.daggerandroid.sample;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import com.daggerandroid.library.DaggerDelegate;
import com.daggerandroid.library.di.component.DaggerComponent;
import com.daggerandroid.sample.di.component.AppComponent;
import com.daggerandroid.sample.di.component.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
public class App extends Application implements HasActivityInjector, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mActivityDispatchingAndroidInjector;

    @Inject
    DispatchingAndroidInjector<Fragment> mFragmentDispatchingAndroidInjector;

    private AppComponent mAppComponent;
    private DaggerDelegate mDaggerDelegate;

    @Override
    public void onCreate() {
        super.onCreate();

        //Library 的依赖注入
        mDaggerDelegate = new DaggerDelegate(this);
        mDaggerDelegate.onCreate();

        mAppComponent = DaggerAppComponent.builder()
                .daggerComponent(getDaggerDelegate())
                .build();
        mAppComponent.inject(this);
    }

    public AppComponent getAppCompoent() {
        return mAppComponent;
    }

    public DaggerComponent getDaggerDelegate() {
        return mDaggerDelegate.getDaggerComponent();
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mActivityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return mFragmentDispatchingAndroidInjector;
    }
}
