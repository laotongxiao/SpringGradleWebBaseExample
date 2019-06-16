package com.demo01.test01.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class HelloData {
    @Autowired
    private Integer helloId;
    @Autowired
    private List<String> listHello;

    public Integer getHelloId() {
        return helloId;
    }

    public void setHelloId(Integer helloId) {
        this.helloId = helloId;
    }

    public List<String> getListHello() {
        return listHello;
    }

    public void setListHello(List<String> listHello) {
        this.listHello = listHello;
    }
}
