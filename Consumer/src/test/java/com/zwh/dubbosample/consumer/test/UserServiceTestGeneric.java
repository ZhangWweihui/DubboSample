package com.zwh.dubbosample.consumer.test;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.MonitorConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhangWeihui
 * @date 2019/6/17 14:01
 */
public class UserServiceTestGeneric {

    private GenericService genericService;

    @Before
    public void setup(){
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubboSampleConsumer");

        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("47.104.103.95:2181");
        registry.setProtocol("zookeeper");

        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");

        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setInterface("com.zwh.sdk.UserServiceBO");
        reference.setVersion("1.0.0");
        reference.setGroup("dubbo");
        reference.setTimeout(5000);
        //reference.setInjvm(false);
        //reference.setScope("local");
        reference.setMonitor(monitorConfig);
        reference.setGeneric(true);
        genericService = reference.get();
    }

    @Test
    public void testSayHello(){
        Object result = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"Strong"});
        Assert.assertEquals("sayHello:Strong", result);
    }

    @Test
    public void testSayHello2(){
        Object result = genericService.$invoke("sayHello2", new String[]{"java.lang.String"}, new Object[]{"Strong"});
        Assert.assertEquals("sayHello2:Strong", result);
    }

    @Test
    public void testPojo(){
        //POJO参数转换为map
        Map<String, Object> map = new HashMap<>();
        map.put("class", "com.zwh.sdk.PersonImpl");
        map.put("name", "William");
        map.put("age", "20");
        Object result = genericService.$invoke("testPojo", new String[]{"com.zwh.sdk.Person"}, new Object[]{map});
        Assert.assertNotNull(result);
        System.out.println(result);
    }
}
