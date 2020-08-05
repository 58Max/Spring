package com.max.bussines;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component("txDemo")
public class  TXDemo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 如果我想把updateUser方法看做一个事务
     * 那么updateUser方法里面的两个update操作实际上就是在一个事务里
     * 根据事务的一致性，事务的原子性 把事务中的所有SQL操作看做一个整体 有原子的不可分割性
     * 一个事务里的所有操作 要么全部成功 要么全部失败
     * 想要把两个update方法放在一个事务里有两种方式
     * 1.自己写代码做事务管理 编程式事务管理 细粒度的管理
     * 2.声明方式 在Spring配置专门的事务管理  声明式事务管理 粗粒度的管理 在方法层面上
     */
    public  void updateUser(){

        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"58max!!",1});
        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"MASIWEI!!",2});

    }

    /**
     * 编程式事务管理
     * 手动编程实现事务管理
     * 编程式事务管理可以自己控制事务管理的精确性 ，精确到把一个方法的部分SQL操作放在一个事务中
     */
    public  void updateUserTx(){

        DefaultTransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(jdbcTemplate.getDataSource());

        TransactionStatus tx = dataSourceTransactionManager.getTransaction(defaultTransactionDefinition);


        try {
            jdbcTemplate.update("update user set name = ? where id = ?", new Object[]{"58max!!", 1});
            jdbcTemplate.update("update user set name = ? where id = ?", new Object[]{"MASIWEI!!", 2});
            dataSourceTransactionManager.commit(tx);
        }catch (Exception exception){
            exception.getMessage();
            dataSourceTransactionManager.rollback(tx);
        }

    }

    /**
     * 声明式事务管理
     * 把updateUserSt看做一个整体的事务
     *
     */
    public  void updateUserSt(){

        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"58max!!",1});
        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"MASIWEI!!",2});

    }


    public  void setUser(){

        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"58max!!",1});
        jdbcTemplate.update("update user set name = ? where id = ?",new Object[]{"MASIWEI!!",2});

    }

}
