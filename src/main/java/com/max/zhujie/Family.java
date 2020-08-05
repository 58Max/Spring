package com.max.zhujie;

import org.springframework.stereotype.Component;

@Component
public class Family {

    public String adress = "光明小区";

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
