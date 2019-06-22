package com.zwh.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 14:47
 */
@SPI
public interface Aircraft {

    @Adaptive({"aircraft"})
    void fly(URL url);
}
