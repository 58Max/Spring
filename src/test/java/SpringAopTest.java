import com.max.one.AOP.Student;
import com.max.one.AOP.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAopTest {

    public static void main(String[] args){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student stu = (Student) applicationContext .getBean("student0");

//        User user = (User)applicationContext .getBean("user");

//        stu.study();

//        stu.testEx();
//        stu.getStr("58max");
//        stu.add(1,2);

//        user.userInfo();

    }

}
