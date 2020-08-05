import com.max.zhujie.MyEmp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

//        Person person = (Person) context.getBean("person");
//        person.test();
        MyEmp myEmp = (MyEmp) context.getBean("myEmp");
//        System.out.println(myEmp.myDept.dName);
        System.out.println(myEmp.getFamily());

    }
}
