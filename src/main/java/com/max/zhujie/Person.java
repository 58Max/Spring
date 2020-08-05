package com.max.zhujie;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

/**
 * 注解模式的IOC 在class类上面添加@Component注解 这个类的bean默认的id是类名的首字母小写
 * 比如Person的id就是小写的person
 * 可以指定bean的id @Component("指定的id")
 * @Controller,@Service,@Repository一样
 *
 * @Component 用来注册普通的bean（就是在三层架构中不是任何一层的）
 * @Controller 用来注册表现层Controller的bean
 * @Service 用来注册业务逻辑层的bean
 * @Resposiroey 用来注册数据访问层bean
 * 这四种注解都能注册bean
 * 这四个注解是在开发逻辑上做了区分
 * 就像mybatis的底层 insert，update，delete在底层代码一致 都是最终走的是update方法
 *
 */
//@Component()
//    @Controller()

public class Person {

    public void test(){
        System.out.println("访问Person的test方法");
    }
}
