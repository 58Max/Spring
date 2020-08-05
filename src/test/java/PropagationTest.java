import com.max.propagation.PropagationDemo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PropagationTest {

    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PropagationDemo propagationDemo = (PropagationDemo) context.getBean("propagationDemo");

        propagationDemo.proUpdateUser();

    }
}
