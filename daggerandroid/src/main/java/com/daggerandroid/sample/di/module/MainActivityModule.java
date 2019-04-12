package com.daggerandroid.sample.di.module;

import com.daggerandroid.library.di.scope.ActivityScope;
import com.daggerandroid.sample.MainActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
//@Module(subcomponents = {MainActivitySubCompoent.class})
@Module
public abstract class MainActivityModule {

//    @Binds
//    @IntoMap
//    @ActivityKey(MainActivity.class)
//    abstract AndroidInjector.Factory<? extends Activity>
//    bindActivityInjectorFactory(MainActivitySubCompoent.Builder builder);

    @ActivityScope
    @ContributesAndroidInjector(modules = StudentModule.class)
    abstract MainActivity contributeMainActivity();
}
