package com.max.zhujie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class MyEmp {
    public String eName;

    /**
     * @AutoWired 可以做依赖注入
     * 根据属性的类型注入bean
     * 当该类型的bean不是只有一个时，就按照bean的id注入（找与属性名相同的id的bean）
     * 与属性名相同id的bean也找不到时，如果只存在一个该类型的bean就会使用这个bean，
     * 当存在多个该类型的bean时可以使用@Qualifier("id")来指定
     * 注入相应的id的bean
     */
    @Autowired
    public MyDept myDept;

    /**
     * 默认根据id注入 找与属性名一致的id
     * 当找不到属性名一致的id 的bean 找与属性类型一致的
     * 有多个该类型的bean时报错
     * 如果都没有 报错
     * 可以使用name属性来指定bean
     * 使用type属性指定注入的bean type的值就是bean的类型
     * 可以name 和 type 一起使用指定 唯一的bean
     *
     * @Autowired是SPring提供的直接 @Resource是j2ee提供的 是与Spring解耦合的
     */
    @Resource
    public Family family;

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getFamily(){

        return this.family.adress;
    }
}
