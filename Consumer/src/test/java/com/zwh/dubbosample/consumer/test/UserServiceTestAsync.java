package com.zwh.dubbosample.consumer.test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.MonitorConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.rpc.RpcContext;
import com.zwh.sdk.UserServiceBO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.Future;

/**
 * @author ZhangWeihui
 * @date 2019/6/17 14:48
 */
public class UserServiceTestAsync {

    private UserServiceBO userService;

    @Before
    public void setup(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubboSampleConsumer");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("47.104.103.95:2181");
        registry.setProtocol("zookeeper");

        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");

        ReferenceConfig<UserServiceBO> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface(UserServiceBO.class);
        reference.setVersion("1.0.0");
        reference.setGroup("dubbo");
        reference.setTimeout(5000);
        reference.setMonitor(monitorConfig);
        reference.setAsync(true);

        userService = reference.get();
    }

    @Test
    public void test1() throws Exception{
        long start = System.currentTimeMillis();
        String result1 = userService.sayHello("dubbo");
        Assert.assertNull(result1);
        Future<String> future1 = RpcContext.getContext().getFuture();

        String result2 = userService.sayHello2("dubbo");
        Assert.assertNull(result2);
        Future<String> future2 = RpcContext.getContext().getFuture();

        String s1 = future1.get();
        String s2 = future2.get();
        Assert.assertEquals("sayHello:dubbo", s1);
        Assert.assertEquals("sayHello2:dubbo", s2);
        System.out.println("cost time:"+(System.currentTimeMillis() - start));
    }
}
