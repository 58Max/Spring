import com.max.advice.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student stu = (Student) context.getBean("student0");

//        stu.test();
        stu.test1();
    }
}
