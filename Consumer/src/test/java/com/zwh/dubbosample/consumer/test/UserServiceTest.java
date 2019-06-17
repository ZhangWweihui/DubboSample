package com.zwh.dubbosample.consumer.test;

import com.zwh.sdk.UserServiceBO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dubbo-consumer.xml")
public class UserServiceTest {

    @Autowired
    private UserServiceBO userService;

    @Test
    public void testSayHello(){
        Assert.assertNotNull(userService);
        String result = userService.sayHello("dubbo");
        Assert.assertEquals("sayHello:dubbo", result);
    }

    @Test
    public void testSayHello2(){
        Assert.assertNotNull(userService);
        String result = userService.sayHello2("dubbo");
        Assert.assertEquals("sayHello2:dubbo", result);
    }
}
