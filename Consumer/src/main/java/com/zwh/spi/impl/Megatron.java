package com.zwh.spi.impl;

import com.zwh.spi.Aircraft;
import com.zwh.spi.Robot;
import org.apache.dubbo.common.URL;

/**
 * @author ZhangWeihui
 * @date 2019/6/21 14:41
 */
public class Megatron implements Robot {

    private Aircraft aircraft;

    public Aircraft getWarplane() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    @Override
    public void sayHello(URL url) {
        System.out.println("Hello, I am Megatron.");
        aircraft.fly(url);
    }
}
