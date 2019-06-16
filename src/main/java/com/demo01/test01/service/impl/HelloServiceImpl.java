package com.demo01.test01.service.impl;

import com.demo01.test01.model.HelloData;
import com.demo01.test01.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service(value = "helloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloData getHelloData(Integer helloId) {
        List<String> listdata = new ArrayList<String>();
        listdata.add("hello a");
        listdata.add("hello 劳同晓");
        listdata.add("hello c");
        HelloData helloData = new HelloData();
        helloData.setHelloId(helloId);
        helloData.setListHello(listdata);
        return helloData;
    }
}
