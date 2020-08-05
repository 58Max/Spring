import com.max.bussines.TXDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TXTest {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        TXDemo txDemo = (TXDemo) context.getBean("txDemo");

//        txDemo.updateUser();
//        txDemo.updateUserTx();
//        txDemo.updateUserSt();
        txDemo.setUser();
    }

}
