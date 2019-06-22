package com.zwh.dubbosample.spi;

import com.zwh.spi.Robot;
import com.zwh.spi.impl.Megatron;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 11:01
 */
public class DubboSPITest {

    @Test
    public void test1() {
        String urlStr = "dubbo://127.0.0.1:20880/XxxService?aircraft=warplane&remark=1024";
        URL url = URL.valueOf(urlStr);
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
        Robot bumblebee = extensionLoader.getExtension("bumblebee");
        Assert.assertNotNull(bumblebee);
        bumblebee.sayHello(url);
        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
        Assert.assertNotNull(optimusPrime);
        optimusPrime.sayHello(url);
        //注意：Dubbo SPI的依赖注入是通过URL指定实现类，且为实现类自动生成了代理
        Robot megatron = extensionLoader.getExtension("megatron");
        Assert.assertNotNull(megatron);
        Assert.assertNotNull(((Megatron)megatron).getWarplane());
        megatron.sayHello(url);
    }
}
