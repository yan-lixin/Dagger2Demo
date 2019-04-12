package com.daggerandroid.sample.di.component;

import com.daggerandroid.library.di.scope.ActivityScope;
import com.daggerandroid.sample.MainActivity;
import com.daggerandroid.sample.di.module.StudentModule;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
@ActivityScope
@Subcomponent(modules = {StudentModule.class})
public interface MainActivitySubCompoent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
