package com.android_lab.sqlitedemo;

import java.io.Serializable;

public class Student implements Serializable {
    long _ID;
    String name;
    String rollNo;
    int age;

    public Student(String name, String rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }
}
