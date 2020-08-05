package com.max.zero;

import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.invoke.MethodHandleInfo;
import java.lang.reflect.Method;

/**
 * 动态代理处理器
 * 规定对被代理的目标对象的方法进行什么样的扩展
 */
public class CglibProxyHandler implements MethodInterceptor {

    //被代理的目标对象
    private Object target;

    /**
     *根据被代理目标对象返回其代理对象
     */
    public Object getInstance(Object target){

        this.target = target;

        //创建加强器 用来创建代理类
        Enhancer enhancer = new Enhancer();

        /**
         * cglib是通过继承父类的方式实现的动态代理
         * 这里的父类指的就是被代理的目标对象的类
         * 继承这个被代理目标对象类的类就是动态的代理类
         * 这个地方参数是 父类（被代理目标对象的class）
         */
        enhancer.setSuperclass(target.getClass());

        /**
         * 这个方法叫做设置回调
         * 实际上就是设置被代理目标对象的方法进行怎样的扩展
         * 这个方法的参数是实现理了MethodInterceptor接口的对象
         * MethodInterceptor的interceptor方法就是定义被代理目标的方法进行怎样的扩展
         */
        enhancer.setCallback((Callback) this);



        //创建动态代理的对象并返回
        return enhancer;
    }

    /**
     *这个方法就是真正对被代理目标对象方法的扩展
     * 参数1 加强器对象
     * 参数2 被代理的目标对象的方法
     * 参数3 方法的参数
     * 参数4 被代理的目标对象的方法的代理方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("=------------------------------");

        methodProxy.invokeSuper(o,objects);//相当于调用原方法

        System.out.println("=------------------------------");

        return null;
    }
}
