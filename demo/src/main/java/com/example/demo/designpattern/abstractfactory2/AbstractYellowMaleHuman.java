package com.example.demo.designpattern.abstractfactory2;

public abstract class AbstractYellowMaleHuman extends AbstractYellowHuman {

    @Override
    public void sex() {
        System.out.println("该黄种人的性别为男....");
    }
}
