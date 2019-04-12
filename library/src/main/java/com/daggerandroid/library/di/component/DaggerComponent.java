package com.daggerandroid.library.di.component;

import android.app.Application;
import com.daggerandroid.library.DaggerDelegate;
import com.daggerandroid.library.di.module.DaggerModule;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

import javax.inject.Singleton;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description: 顶级注入器
 * 主要提供一些全局依赖
 */
@Singleton
@Component(modules = {AndroidInjectionModule.class, DaggerModule.class})
public interface DaggerComponent {

    Application application();

    void inject(DaggerDelegate daggerDelegate);
}
