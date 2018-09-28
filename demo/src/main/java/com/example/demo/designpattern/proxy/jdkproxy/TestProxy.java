package com.example.demo.designpattern.proxy.jdkproxy;

import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {
        RealClass realClass = new RealClass();
        MyHandler myHandler= new MyHandler(realClass);
        IService proxyInstance = (IService)Proxy.newProxyInstance(realClass.getClass().getClassLoader(), new Class[]{IService.class}, myHandler);
        proxyInstance.sayHello();
    }
}
