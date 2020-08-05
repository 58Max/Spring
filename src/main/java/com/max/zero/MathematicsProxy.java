package com.max.zero;

public class MathematicsProxy implements MathematicsDao{

    MathematicsImpl mathematics ;

    public MathematicsProxy(MathematicsImpl mathematics){
        this.mathematics = mathematics;
    }

    @Override
    public void add(int a, int b) {
        System.out.println("输入的参数是：" + a + "," + b);
        this.mathematics.add(a,b);
        System.out.println("add方法执行完毕");
    }
}
