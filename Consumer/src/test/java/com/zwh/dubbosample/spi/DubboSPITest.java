package com.zwh.dubbosample.spi;

import com.zwh.spi.Robot;
import com.zwh.spi.impl.Megatron;
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
        ExtensionLoader<Robot> extensionLoader = ExtensionLoader.getExtensionLoader(Robot.class);
        System.out.println("Dubbo SPI");
//        Robot bumblebee = extensionLoader.getExtension("bumblebee");
//        Assert.assertNotNull(bumblebee);
//        bumblebee.sayHello();
//        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//        Assert.assertNotNull(optimusPrime);
//        optimusPrime.sayHello();

        Robot megatron = extensionLoader.getExtension("megatron");
        Assert.assertNotNull(megatron);
        Assert.assertNotNull(((Megatron)megatron).getWarplane());
        megatron.sayHello();
    }
}
