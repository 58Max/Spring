package com.max.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;
    /**
     * 1.减余额
     */
    public void updateBalance(String username,int balance){
        String sql = "";
    }

    public int getPrice(String isbn){
        String sql="";
        return jdbcTemplate.queryForObject(sql,Integer.class,isbn);

    }



}
