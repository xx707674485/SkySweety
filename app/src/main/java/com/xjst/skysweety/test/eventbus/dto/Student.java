package com.xjst.skysweety.test.eventbus.dto;

import android.util.Log;

import java.lang.reflect.Proxy;

import leo.android.cglib.proxy.EnhancerInterface;
import leo.android.cglib.proxy.MethodInterceptor;
import leo.android.cglib.proxy.MethodProxy;

/**
 * 作者：zx on 2018/3/19 16:09
 * 描述:
 */
public class Student {
    private static final String TAG = "Student";
    private String name;
    private String age;
    private String sex;


    public Student() {
    }

    public Student(String name, String age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        Log.d(TAG, "setName: ");
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private MethodInterceptor methodInterceptor;

//    @Override
//    public void setMethodInterceptor$Enhancer$(MethodInterceptor methodInterceptor) {
//        this.methodInterceptor = methodInterceptor;
//    }




}
