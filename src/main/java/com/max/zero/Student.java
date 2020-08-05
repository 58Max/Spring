package com.max.zero;

import java.util.List;

public class Student {
    public String name = "张三";
    public int age = 21;
    public String[] strs;
    public List<String> list;


    public Student(String name, int age ){
        this.name = name;
        this.age = age;
    }
    public Student() {

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

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
