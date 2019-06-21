package com.zwh.spi.impl;

import com.zwh.spi.Aircraft;
import com.zwh.spi.Robot;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 14:41
 */
public class Megatron implements Robot {

    private Aircraft warplane;

    public Aircraft getWarplane() {
        return warplane;
    }

    public void setWarplane(Aircraft warplane) {
        this.warplane = warplane;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, I am Megatron.");
        warplane.fly();
    }
}
