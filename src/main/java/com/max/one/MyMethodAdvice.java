package com.max.one;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Modifier;

/**
 * 该方法是Spring的通知Advice类
 * 这个类就是具体执行对目标的对象的方法进行怎样的拓展
 * 这个类就是切面 aspects
 */
public class MyMethodAdvice {

    /**
     * PointCut有哪些 在目标方法的那些位置可以进行拓展
     * 1.在方法执行前
     * 2.在方法执行后
     * 3.如果方法有返回值，在方法返回值之后
     * 4.如果方法存在异常 在方法出现异常后
     *
     * 我们可以从以上四个位置进行拓展
     * 我们需要定义4个通知方法来完成以上拓展
     */

    /**
     * 前置通知
     *
     * @param joinPoint 连接点 要进行拓展和分层的方法
     */
    public void before(JoinPoint joinPoint) {
//        System.out.println("前置通知");
//        //JoinPoint连接点的API
//        System.out.println("被代理的对象: " + joinPoint.getTarget());
//        System.out.println("代理的对象: " + joinPoint.getThis());
//
//        System.out.println(joinPoint.getTarget() == joinPoint.getThis());
//        //目标方法就是被做通知的方法名
//        System.out.println("目标方法名: " + joinPoint.getSignature().getName());
//        //目标方法所属类的简单类名
//        System.out.println("目标方法名所属类的简单类名: " + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        //目标方法名所属类的类名
//        System.out.println("目标方法名所属类的类名: " + joinPoint.getSignature().getDeclaringTypeName());
//        //目标方法声明的类型
//        System.out.println("目标方法声明的类型：" + Modifier.toString(joinPoint.getSignature().getModifiers()));
//        //传入目标方法的参数
//        Object args[] = joinPoint.getArgs();
//        int i = 1;
//        for (Object arg : args) {
//            System.out.println("传入目标方法的第" + i + "参数： " + arg);
//            i++;
//        }
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String typeName = Modifier.toString(joinPoint.getSignature().getModifiers());
        String methodName = joinPoint.getSignature().getName();

        Object[] args = joinPoint.getArgs();

        if("Student".equals(className) && "public".equals(typeName)) {

            String loggermsg = "执行了" + className + "类的方法" + methodName + "的类型: " + typeName + ",传递参数：";
            if(args.length > 0){
                for (Object arg : args){
                loggermsg += arg + ",";
                }
                loggermsg = loggermsg.substring(0,loggermsg.length()-1) + "。";
            }else{
                loggermsg += "null。";
            }

            System.out.println(loggermsg);

    }


}

    /**
     * 后置通知
     * @param joinPoint 连接点 要进行拓展和分层的方法
     */
    public void after(JoinPoint joinPoint){
        System.out.println("后置通知");
    }

    /**
     * 返回后通知
     * @param joinPoint 连接点 要进行拓展和分层的方法
     * @param object 连接点的返回值 要进行拓展方法的返回值
     */
    public void afterReturning(JoinPoint joinPoint,Object object){
        System.out.println("返回后通知，返回值：" + object );
    }

    /**
     * 异常通知
     * @param joinPoint 连接点 要进行拓展和分层的方法
     * @param exception 连接点的异常
     */
    public void afterThrowing(JoinPoint joinPoint,Exception exception){
        System.out.println("异常通知，异常：" + exception.getMessage());
    }

    /**
     * 如果对一个连接点方法 去扩展几个位置 （方法执行前 执行后 异常 返回值）
     * 可以在一个通知中完成4个切入点
     * 这个通知就是环绕通知
     */
    /**
     *
     * @param proceedingJoinPoint  连接点
     * @return
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
//
//        System.out.println("被代理的对象是：" + proceedingJoinPoint.getTarget()+ "。" );
//        System.out.println("代理的对象是：" + proceedingJoinPoint.getThis()+ "。" );
//        System.out.println("目标方法名是：" + proceedingJoinPoint.getSignature().getName()+ "。" );
//        System.out.println("目标方法所属简单类名是：" + proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName()+ "。" );
//        System.out.println("目标方法所属全类名是：" + proceedingJoinPoint.getSignature().getDeclaringTypeName()+ "。" );
//        System.out.println("声明方法的类型是：" + Modifier.toString(proceedingJoinPoint.getSignature().getDeclaringType().getModifiers()));
//
//        Object[] args = proceedingJoinPoint.getArgs();
//        int i = 1;
//        for(Object arg : args){
//
//            System.out.println("第" + i + "个参数是：" + arg + " ,");
//            i++;
//
//        }


        System.out.println("----------------------------------------");
        Object res = null;//声明接收返回值的变量

        try {
            System.out.println("方法执行前逻辑");//相当于单独的前置通知

            String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
            String typeName = Modifier.toString(proceedingJoinPoint.getSignature().getModifiers());
            String methodName = proceedingJoinPoint.getSignature().getName();

            Object[] args = proceedingJoinPoint.getArgs();

            if("Student".equals(className) && "public".equals(typeName)) {

                String loggermsg = "执行了" + className + "类的方法" + methodName + "的类型: " + typeName + ",传递参数：";
                if(args.length > 0){
                    for (Object arg : args){
                        loggermsg += arg + ",";
                    }
                    loggermsg = loggermsg.substring(0,loggermsg.length()-1) + "。";
                }else{
                    loggermsg += "null。";
                }

                System.out.println(loggermsg);

            }


            res = proceedingJoinPoint.proceed();//原样执行连接点（要扩展）的方法
            /**
             * 环绕通知的 proceedingJoinPoint 参数有一个proceed()
             * 这个方法可以改变传入目标方法的参数
             * 给proceed传入新的参数就可以
             * 注意传入的参数类型要与目标方法的类型一致
             */
//            Object[] newargs = new Object[]{3,4};
//            res = proceedingJoinPoint.proceed(newargs);
            System.out.println("方法执行返回后逻辑，返回值： " + res);//相当于单独的返回值通知
        } catch (Throwable throwable) {

            System.out.println("方法执行异常逻辑");//相当于单独的异常通知
            throwable.printStackTrace();
        }

        System.out.println("方法执行后的逻辑");//相当于单独的后置通知

        return  res;
    }
}
