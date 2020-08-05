package com.max.datasource;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 做实体类与查询结果的映射
 * 最后返回实体类对象的集合
 * 实现RowMapper<>接口
 * RowMapper接口有一个泛型，这些泛型就是要做映射的那个实体类
 */
public class UserResult implements RowMapper<User> {

    /**
     * 遍历结果集的每一行
     * 把每一行查询结果放到一个实体类对象中(一行对应一个实体类对象)
     * @param resultSet 每一行的结果集
     * @param i 索引值 从0开始，没遍历完一行 +1
     * @return 返回值是实现接口的泛型
     * @throws SQLException
     */
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {

        User user = new User();
        System.out.println("遍历的是第" + (i+1) + "行的数据.");
        //根据字段名把result中值赋予给相应实体类对象属性
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        return user;
    }
}
