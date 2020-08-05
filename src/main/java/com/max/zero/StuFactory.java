package com.max.zero;

public class StuFactory {

    public static Student newInstance(){
        return  new Student();
    }

    public Student getStudent(){
        return  new Student("实例工厂",13);
    }
}
