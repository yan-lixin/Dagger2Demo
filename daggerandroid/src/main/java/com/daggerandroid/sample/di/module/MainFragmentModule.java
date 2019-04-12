package com.daggerandroid.sample.di.module;

import com.daggerandroid.library.di.scope.FragmentScope;
import com.daggerandroid.sample.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
@Module
public abstract class MainFragmentModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = StudentModule.class)
    abstract MainFragment contributeMainFragment();
}
