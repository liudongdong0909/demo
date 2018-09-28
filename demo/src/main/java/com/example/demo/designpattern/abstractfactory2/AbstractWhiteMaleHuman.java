package com.example.demo.designpattern.abstractfactory2;

public abstract class AbstractWhiteMaleHuman extends AbstractWhiteHuman {

    @Override
    public void sex() {
        System.out.println("该白种人的性别为男....");
    }
}
