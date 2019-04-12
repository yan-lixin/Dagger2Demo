package com.daggerandroid.sample.di.component;

import com.daggerandroid.library.di.component.DaggerComponent;
import com.daggerandroid.library.di.scope.AppScope;
import com.daggerandroid.sample.App;
import com.daggerandroid.sample.di.module.AppModule;
import com.daggerandroid.sample.di.module.MainActivityModule;
import com.daggerandroid.sample.di.module.MainFragmentModule;
import dagger.Component;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description: 主 Module 的全局注入器，它仅限定于 @AppScope。
 *
 * AppComponent 是依赖于 DaggerComponent，也就是说，DaggerComponent 顶级注入器，AppComponent 是主 Module 的注入器。
 */
@AppScope
@Component(
        dependencies = DaggerComponent.class,
        modules = {
                AppModule.class,
                MainActivityModule.class,
                MainFragmentModule.class
        }
)
public interface AppComponent {
    void inject(App app);
}
