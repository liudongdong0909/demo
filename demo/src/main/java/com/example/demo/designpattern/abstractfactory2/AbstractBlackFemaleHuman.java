package com.example.demo.designpattern.abstractfactory2;

public abstract class AbstractBlackFemaleHuman extends AbstractBlackHuman {

    @Override
    public void sex() {
        System.out.println("该黑种人的性别为女...");
    }
}
