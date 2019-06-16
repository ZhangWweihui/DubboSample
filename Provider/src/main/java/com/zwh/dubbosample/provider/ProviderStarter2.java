package com.zwh.dubbosample.provider;

import com.alibaba.dubbo.config.*;
import com.zwh.dubbosample.provider.service.UserServiceImpl;
import com.zwh.dubbosample.sdk.UserServiceBO;

/**
 * @Description 通过Dubbo API启动provider
 * @Author zhangweihui
 * @Date 2019-6-16
 */
public class ProviderStarter2 {

    public static void main(String[] args) {
        //（4.3.1-1）等价于  <bean id="userService" class="com.test.UserServiceImpl" />
        UserServiceBO userService = new UserServiceImpl();

        //（4.3.1-2）等价于  <dubbo:application name="dubboProvider" />
        ApplicationConfig application = new ApplicationConfig();
        application.setName("dubboSampleProvider");

        //（4.3.1-3）等价于  <dubbo:registry address="zookeeper://127.0.0.1:2181" />
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("47.104.103.95:2181");
        registry.setProtocol("zookeeper");

        // （4.3.1-4）等价于 <dubbo:protocol name="dubbo" port="20880" />
        ProtocolConfig protocol = new ProtocolConfig();
        protocol.setName("dubbo");
        protocol.setPort(20880);

        //4.3.1-5）等价于     <dubbo:monitor protocol="registry" />
        MonitorConfig monitorConfig = new MonitorConfig();
        monitorConfig.setProtocol("registry");

        //4.3.1-6）等价于 <dubbo:service interface="com.test.UserServiceBo" ref="userService"
        //group="dubbo"  version="1.0.0" timeout="3000"/>
        ServiceConfig<UserServiceBO> service = new ServiceConfig<UserServiceBO>(); // 此实例很重，封装了与注册中心的连接，请自行缓存，否则可能造成内存和连接泄漏
        service.setApplication(application);
        service.setMonitor(monitorConfig);
        service.setRegistry(registry); // 多个注册中心可以用setRegistries()
        service.setProtocol(protocol); // 多个协议可以用setProtocols()
        service.setInterface(UserServiceBO.class);
        service.setRef(userService);
        service.setVersion("1.0.0");
        service.setGroup("dubbo");
        service.setTimeout(3000);
        service.export();

        //4.3.1-8） 挂起当前线程
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
