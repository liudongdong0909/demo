package com.example.demo.designpattern.proxy.jdkproxy;

public class RealClass implements IService {
    @Override
    public void sayHello() {
        System.out.println("say  hello world ... ");
    }

    public void doService(){
        System.out.println("do service ...");
    }
}
