package com.zwh.spi.impl;

import com.zwh.spi.Aircraft;
import org.apache.dubbo.common.URL;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 14:49
 */
public class Warplane implements Aircraft {

    @Override
    public void fly(URL url) {
        System.out.println("I can fly and bomb.");
        System.out.println(url.getParameter("remark"));
        System.out.println(url.getParameter("poem", "With determination and dedication, you can make it happen"));
    }
}
