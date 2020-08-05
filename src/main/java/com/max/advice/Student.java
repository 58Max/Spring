package com.max.advice;

import org.springframework.stereotype.Component;

@Component("student0")
public class Student {

    public void test(){
        System.out.println("这是test方法");
    }

    public String test1(){
        return "hello";
    }

}
