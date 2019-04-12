package com.daggerandroid.library;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import dagger.android.AndroidInjection;
import dagger.android.support.HasSupportFragmentInjector;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description: 全局 Activity 依赖注入
 * 使用 ActivityLifecycleCallbacks 全局监听 Activity 的生命周期，对 Dagger.Android 进行统一注入管理。
 */
@Singleton
public class DaggerActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    @Inject
    DaggerFragmentLifecycleCallbacks mDaggerFragmentLifecycleCallbacks;

    @Inject
    public DaggerActivityLifecycleCallbacks() {
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Log.i(activity.getLocalClassName(), "onActivityCreated");
        //Dagger.Android Inject for Activity
        AndroidInjection.inject(activity);

        if (activity instanceof HasSupportFragmentInjector
                || activity.getApplication() instanceof HasSupportFragmentInjector) {
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(mDaggerFragmentLifecycleCallbacks, true);
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.i(activity.getLocalClassName(), "onActivityDestroyed");
    }
}
