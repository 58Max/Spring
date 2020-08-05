import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo {

    private static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    public static void main(String[] args){

//        insert();
//        insert1();
//        delete();
//        selUser();
//        selUsers();
//        selCount();
        selUserName();
    }



    /**
     * 无参写操作
     */

    public static void insert(){
        String sql = "insert into user(id,name) values(4,'P.SYP')";
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        int  res = jdbcTemplate.update(sql);
        System.out.println(res);
    }

    /**
     * 有参写操作 如果有需要的传递的参数 也就是SQL语句中有需要被替换的占位符
     * 使用Objec数组传递 ，数组元素的顺序与占位符的顺序对应
     */
    public static void insert1(){
        String sql = "insert into user(id,name) values(?,?)";
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        int  res = jdbcTemplate.update(sql,new Object[]{5, "MELO"});
        System.out.println(res);
    }

    public static void delete(){

//        String sql = "delete from user where id = 9";
        String sql = "delete from user where id = ?";
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        int res = jdbcTemplate.update(sql,new Object[]{8});
        System.out.println(res);

    }

    /**
     * 查询单条 返回值是 Map
     */
    public static void  selUser(){

        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "select * from user where id = ?";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,new Object[]{2});
        System.out.println(map);
    }

    /**
     * 查询多条 返回值是List<Map>
     */
    public static void selUsers(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "select * from user where id in (?,?,?)";
        List list = jdbcTemplate.queryForList(sql,new Object[]{1,2,3});
        System.out.println(list);
    }

    /**
     * 单一值查询
     */
    public static void selCount(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "select count(id)  from user";
        /**
         * 第一个参数是 SQL语句
         * 第二个参数 是查询字段的数据的数据类型
         */
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }

    public static void selUserName(){
        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        String sql = "select name from user where id = ?";
//        String name = jdbcTemplate.queryForObject(sql,String.class);
        /**
         * 第一个参数是 SQL语句
         * 第二个参数 是查询字段的数据的数据类型
         * 第三个参数 如果SQL语句中有占位符 参数三就是对应占位符的值 数组元素的属性与占位符的顺序对应
         */
        String name = jdbcTemplate.queryForObject(sql,String.class,2);
        System.out.println(name);
    }
}
