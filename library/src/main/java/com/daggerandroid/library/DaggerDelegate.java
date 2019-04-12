package com.daggerandroid.library;

import android.app.Application;
import com.daggerandroid.library.di.component.DaggerComponent;
import com.daggerandroid.library.di.component.DaggerDaggerComponent;
import com.daggerandroid.library.di.module.DaggerModule;

import javax.inject.Inject;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description: 是一个代理类，为了克服 Application 继承的问题，通过封装一个代理类来对 library 的 Dagger 注入进行管理，然后在需要的 Module 里使用。
 */
public class DaggerDelegate {

    @Inject
    DaggerActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    private DaggerComponent mDaggerComponent;

    private final Application mApplication;

    public DaggerDelegate(Application mApplication) {
        this.mApplication = mApplication;
    }

    public void onCreate() {
        mDaggerComponent = DaggerDaggerComponent.builder()
                .daggerModule(new DaggerModule(mApplication))
                .build();
        //顶级依赖注入
        mDaggerComponent.inject(this);

        //注册ActivityLifecycleCallbacks来进行Activity/Fragment的依赖注入
        mApplication.registerActivityLifecycleCallbacks(mActivityLifecycleCallbacks);
    }

    public DaggerComponent getDaggerComponent() {
        return mDaggerComponent;
    }

}
