import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSourceDemo {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        DataSource dataSource = (DataSource) context.getBean("dataSource");

        Connection conn = null;
        Statement statement = null;

        String sql = "insert into user(id,name) values(3,'DZKNOW')";

        try {
            conn = dataSource.getConnection();
            statement= conn.createStatement();
            statement.execute(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                statement.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }

}


