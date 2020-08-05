import com.max.datasource.User;
import com.max.datasource.UserResult;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReusltTest {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

//        String sql = "select * from user";

        /**
         * jdbcTemplate.query(参数1，参数2)
         * 参数1  SQL语句
         * 参数2  实体类与结果集的映射类，这个映射类要实现RowMapper接口
         * jdbcTemplate.query()返回值只有list集合 哪怕只有1条数据
         * 如果只有单条数据 最好使用 list.get(0)来输出
         */
//        List<User> list = jdbcTemplate.query(sql,new UserResult());

        String sql = "select * from user where id in (?,?)";
        /**
         * jdbcTemplate.query(参数1，参数2,参数3)
         * 参数1  SQL语句
         * 参数2  实体类与结果集的映射类，这个映射类要实现RowMapper接口
         * 参数3  替换SQL语句中的占位符 顺序要一直
         */
        List<User> list = jdbcTemplate.query(sql,new UserResult(),new Object[]{1,2});
        System.out.println(list);

    }

}
