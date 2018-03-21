package com.xjst.skysweety.test.eventbus.dto;

/**
 * 作者：zx on 2018/3/19 16:09
 * 描述:
 */
public class Student {
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
}
