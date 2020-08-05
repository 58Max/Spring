package com.max.one.AOP;

public class Student {

    public void study(){
        System.out.println("-----------------学习--------------------------");
    }

    public void testEx(){

        int[] arr = new int[]{1};
        System.out.println(arr[3]);

    }

    public String getStr(String str){

        System.out.println(str);

        return str + "!!";

    }


    public int add(int a , int b){

        return a+b;

    }

}
