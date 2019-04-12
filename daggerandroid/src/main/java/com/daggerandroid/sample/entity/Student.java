package com.daggerandroid.sample.entity;

import javax.inject.Inject;

/**
 * Copyright (c), 2018-2019
 *
 * @author: lixin
 * Date: 2019/4/12
 * Description:
 */
public class Student {
    private String name;
    private int age;

    @Inject
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
