package com.daggerandroid.sample.di.module;

import com.daggerandroid.sample.entity.Student;
import dagger.Module;
import dagger.Provides;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
@Module
public class StudentModule {

    @Provides
    Student provideStudent() {
        return new Student("张三", 3);
    }
}
