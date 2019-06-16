package com.zwh.dubbosample.provider.service;

import com.alibaba.fastjson.JSON;
import com.zwh.dubbosample.sdk.Person;
import com.zwh.dubbosample.sdk.UserServiceBO;

public class UserServiceImpl implements UserServiceBO {

    @Override
    public String sayHello(String name) {
        //让当前当前线程休眠2s
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "sayHello:"+name;
    }

    @Override
    public String sayHello2(String name) {
        //让当前当前线程休眠2s
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "sayHello2:"+name;
    }

    @Override
    public String testPojo(Person person) {
        return JSON.toJSONString(person);
    }
}
