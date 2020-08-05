package com.max.zero;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DemoProxyHandler implements InvocationHandler {

    /**
     * InvocationHandler
     * 这个类是一个动态处理器
     *作用就是规定对指定的方法做什么样的扩展
     *方法肯定是属于对象的
     * JDK动态代理需要被代理类实现接口
     */

    //用来接收需要动态代理扩展方法所属的对象
    private Object obj;

    public DemoProxyHandler(Object obj){
        this.obj = obj;
    }


    /**
     * method是 要扩展的方法
     * args 要扩展的方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /**
         * 扩展的方法前后都可以进行扩展
         */
        System.out.println("=------------------------------");
        Object res = method.invoke(obj,args);//执行要扩展的方法
        System.out.println("=------------------------------");


        return res;
    }
}
