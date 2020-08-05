package com.max.zero;

public class PersonStaticProxy  extends Person{

    @Override
    public void run() {
        System.out.println("run()方法执行前");
        super.run();
        System.out.println("run()方法执行后");
    }
}
