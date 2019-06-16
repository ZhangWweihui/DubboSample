package com.zwh.dubbosample.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProviderStarter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:dubbo-provider.xml");
        //挂起当前线程，如果没有改行代码，服务提供者进程会消亡，服务消费者就发现不了提供者了
        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
