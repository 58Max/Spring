package com.max.zhujie;

import org.springframework.stereotype.Component;

@Component
public class MyDept {

    public String dName = "部门";

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
