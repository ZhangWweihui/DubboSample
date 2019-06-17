package com.zwh.dubbosample.provider.test;

import com.zwh.sdk.UserServiceBO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:dubbo-provider.xml")
public class UserServiceTest {

    @Autowired
    private UserServiceBO userService;

    @Test
    public void test1(){
        Assert.assertNotNull(userService);
    }

}
