package com.zwh.dubbosample.consumer.test;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import com.zwh.sdk.UserServiceBO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description
 * @Author 张炜辉
 * @Date 2019/6/16
 */
public class UserServiceTestByDubboAPI {

    private UserServiceBO userService;

    @Before
    public void setup(){
        // 等价于  <dubbo:application name="dubboConsumer" />
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubboSampleConsumer");

        // 等价于     <dubbo:registry  protocol="zookeeper" address="zookeeper://127.0.0.1:2181" />
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("47.104.103.95:2181");
        registry.setProtocol("zookeeper");

        //等价于   <dubbo:monitor protocol="registry" />
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");

        //等价于<dubbo:reference id="userService" interface="com.test.UserServiceBo"
        //group="dubbo" version="1.0.0" timeout="3000" />
        ReferenceConfig<UserServiceBO> reference = new ReferenceConfig<UserServiceBO>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(UserServiceBO.class);
        reference.setVersion("1.0.0");
        reference.setGroup("dubbo");
        reference.setTimeout(3000);
        //reference.setInjvm(false);
        //reference.setScope("local");
        reference.setMonitor(monitorConfig);

        userService = reference.get();
    }

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
