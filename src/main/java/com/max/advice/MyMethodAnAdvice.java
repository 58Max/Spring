package com.max.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 注解模式的通知
 * @Component 注册bean
 * @Aspect 指定当前的类是切面类
 */
@Component
@Aspect
public class MyMethodAnAdvice {

    /**
     * 直接通过在方法上做注解指定当前的方法是前置通知的方法@Before("execution(范围)")
     * @param joinPoint
     */
    @Before("execution(* com.max.advice.Student.test(..))")
    public void before(JoinPoint joinPoint){

        System.out.println("注解前置通知");

    }

    @After("execution(* com.max.advice.Student.test(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("注解的后置通知");
    }

    /**
     *
     * @param joinPoint 连接点
     * @param result 这个参数要和注解的returning的值一致
     * @return 返回值
     */
    @AfterReturning(value = "execution(* com.max.advice.Student.test1(..))",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("返回后通知，返回值是：" + result);
    }

    /**
     *
     * @param joinPoint 连接点
     * @param exception 要与 注解 throwing的值一致
     */
    @AfterThrowing(value ="execution(* com.max.advice.Student.test1(..))",throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint , Exception exception){
        System.out.println("异常通知： " + exception.getMessage());
    }

    @Around("execution(* com.max.advice.Student.test1(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){

        Object res = null;

        try {
            System.out.println("前置通知");
            res = proceedingJoinPoint.proceed();
            System.out.println("返回值通知：" + res);
        } catch (Throwable throwable) {
            System.out.println("异常通知");
            throwable.printStackTrace();
        }
        System.out.println("后置通知");

        return res;
    }
}
