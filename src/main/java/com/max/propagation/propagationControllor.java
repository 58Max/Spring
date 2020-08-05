package com.max.propagation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class propagationControllor {

    @Autowired
   PropagationDemo propagationDemo;

    /**
     * 如果当前方法存在事务 直接在这个事务中进行
     * 如果当前方法不存在事务 就会开启新的事务
     * propagation="REQUIRED"  proUpdateUser2()和proUpdateUser3()的事务不共享 各自进行各自的事务
     */
   public void proUpdateUser(){
       propagationDemo.proUpdateUser2();
       propagationDemo.proUpdateUser3();

   }


}
