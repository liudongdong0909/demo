package com.example.demo.designpattern.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler{

    private Object object;

    public MyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy begainning ...");
        Object result = method.invoke(object, args);
        System.out.println("proxy end ...");
        return result;
    }
}
