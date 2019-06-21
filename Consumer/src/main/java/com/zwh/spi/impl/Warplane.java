package com.zwh.spi.impl;

import com.zwh.spi.Aircraft;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 14:49
 */
public class Warplane implements Aircraft {

    @Override
    public void fly() {
        System.out.println("I can fly and bomb.");
    }
}
