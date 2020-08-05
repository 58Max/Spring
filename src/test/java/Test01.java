import com.max.zero.CglibProxyHandler;
import com.max.zero.Person;

public class Test01 {

   public static void main(String[] args){
//       com.max.zero.Person p = new com.max.zero.PersonStaticProxy();
//       p.run();

//       com.max.zero.MathematicsDao mathematicsDao = new com.max.zero.MathematicsImpl();
//       mathematicsDao.add(1,2);
//       com.max.zero.MathematicsDao m = new com.max.zero.MathematicsProxy(new com.max.zero.MathematicsImpl());
//       m.add(1,2);

//       com.max.zero.MathematicsDao m = new com.max.zero.MathematicsImpl();

       /**
        * 动态创建代理类
        * 参数1 指定当前被代理的对象的类的加载器
        * 参数2 被代理的目标对象的接口
        * 参数3 指定的动态处理器
        * 动态代理类可以用被代理类的接口类型的变量接收
        */
//       com.max.zero.MathematicsDao mathematicsDao = (com.max.zero.MathematicsDao) Proxy.newProxyInstance(m.getClass().getClassLoader(),m.getClass().getInterfaces(),new com.max.zero.DemoProxyHandler(m));
       /**
        * 这里执行的add方法实际上是执行的DemoProxyHandler的invoke方法
        */
//       mathematicsDao.add(1,2);

       CglibProxyHandler cp = new CglibProxyHandler();
       Person p = (Person)cp.getInstance(new Person());
        p.run();
   }

}
