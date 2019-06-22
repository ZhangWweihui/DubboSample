package com.zwh.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 10:14
 */

@SPI
public interface Robot {

    void sayHello(URL url);
}
