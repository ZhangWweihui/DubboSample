package com.zwh.dubbosample.provider.service;

import com.zwh.sdk.NetworkServiceBO;
import org.apache.dubbo.config.annotation.Service;

/**
 * @author ZhangWeihui
 * @date 2019/7/2 14:51
 */
public class NetworkServiceImpl implements NetworkServiceBO {

    public String connect() {
        return "The network has been connected.";
    }

    public String disconnect() {
        return "The network has been disconnected.";
    }

    public String reconnect() {
        return "The network has been reconnected.";
    }
}