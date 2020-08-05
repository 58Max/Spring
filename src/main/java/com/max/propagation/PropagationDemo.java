package com.max.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component("propagationDemo")
public class PropagationDemo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void proUpdateUser(){

        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"58max!!",1});
        /**
         * 根据<tx:method name="proUpdate*" read-only="false" propagation="REQUIRED"></tx:method>
         * 如果当前有事务就直接在当前事务中执行
         * 如果当前方法没有事务 就创建一个事务
         */

        proUpdateUser1();

    }

    public void proUpdateUser1(){

        jdbcTemplate.update("update user set1 name = ? where id = ?",new Object[]{"MASIWEI!!",2});

    }

    public void proUpdateUser2(){

        jdbcTemplate.update("update user set1 name = ? where id = ?",new Object[]{"58max!!",1});
        jdbcTemplate.update("update user set1 name = ? where id = ?",new Object[]{"MASIWEI!!",2});

    }

    public void proUpdateUser3(){

        jdbcTemplate.update("update user set1 name = ? where id = ?",new Object[]{"DZKNOW!!",3});
        jdbcTemplate.update("update user set1 name = ? where id = ?",new Object[]{"P.SYP!!",4});

    }

}
