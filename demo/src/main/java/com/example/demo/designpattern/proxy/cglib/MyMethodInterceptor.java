package com.example.demo.designpattern.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before  = " + method);
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after   = " + method);
        return object;
    }
}
