package com.example.demo.designpattern.abstractfactory2;

public abstract class AbstractYellowHuman implements Human {

    @Override
    public void cry() {
        System.out.println("黄色人种会哭");
    }

    @Override
    public void laugh() {
        System.out.println("黄色人种会大笑，幸福呀！ ");
    }

    @Override
    public void talk() {
        System.out.println("黄色人种会说话，一般说的都是双字节");
    }
}
