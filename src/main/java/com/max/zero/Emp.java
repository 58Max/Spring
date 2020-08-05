package com.max.zero;

/**
 * Emp的dept是Dept对象
 * 需要依赖Dept类的对象 Spring把Dept 的对象赋值给Emp类的dept属性就是依赖注入 也就是DI
 * Emp类的属性需要setter方法
 */

public class Emp {
    public String eName;
    public Dept dept;

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
