package com.max.zero;

public class Users {

    public Users(){
        System.out.println("调用了User 的构造方法");
    }
    public void init(){
        System.out.println("调用了 com.max.zero.User 的 init 方法");
    }

    public void destory(){
        System.out.println("调用了 com.max.zero.User 的 destory 的方法");
    }
}
