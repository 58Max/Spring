import com.max.zero.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args){

        //加载Spring的配置文件 并且把实例创建出来放在容器中 参数是Spring配置文件的路径
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //执行完new ClassPathXmlApplicationContext("applicationContext.xml")
        //Spring的配置文件中的bean已经存在了
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //运行完 实例已经创建完成

        //从容器中获取bean 参数是bean标签的id 根据id 从容器中拿到已经创建的bean实例

//        com.max.zero.Student stu = (com.max.zero.Student)ctx.getBean("stu");
//        com.max.zero.Student stu = (com.max.zero.Student)ctx.getBean("stu1");
//        com.max.zero.Student stu = (com.max.zero.Student)ctx.getBean("stu3");
//        com.max.zero.Student stu = (com.max.zero.Student)ctx.getBean("stu4");
//
//        com.max.zero.Student stu = (com.max.zero.Student)ctx.getBean("stu5");
//        for(String s :stu.strs){
//            System.out.println(s);
//      }
        Student stu = (Student)ctx.getBean("stu6");
        for(String s :stu.list){
            System.out.println(s);
        }




    }
}
