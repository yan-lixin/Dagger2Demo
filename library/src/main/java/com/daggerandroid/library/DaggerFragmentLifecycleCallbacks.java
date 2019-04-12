package com.daggerandroid.library;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import dagger.android.support.AndroidSupportInjection;

import javax.inject.Inject;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description: 全局 Fragment 依赖注入
 * 使用 FragmentLifecycleCallbacks 全局监听 Fragment 的生命周期，对 Dagger.Android 进行统一注入管理。
 */
public class DaggerFragmentLifecycleCallbacks extends FragmentManager.FragmentLifecycleCallbacks {

    @Inject
    public DaggerFragmentLifecycleCallbacks() {
    }

    @Override
    public void onFragmentAttached(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull Context context) {
        super.onFragmentAttached(fm, f, context);
        Log.i(f.toString(), "onFragmentAttached");
        //Dagger.Android Inject for Fragment
        AndroidSupportInjection.inject(f);
    }

    @Override
    public void onFragmentActivityCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @Nullable Bundle savedInstanceState) {
        super.onFragmentActivityCreated(fm, f, savedInstanceState);
        Log.i(f.toString(), "onFragmentActivityCreated");
    }

    @Override
    public void onFragmentDetached(@NonNull FragmentManager fm, @NonNull Fragment f) {
        super.onFragmentDetached(fm, f);
        Log.i(f.toString(), "onFragmentDetached");
    }
}
