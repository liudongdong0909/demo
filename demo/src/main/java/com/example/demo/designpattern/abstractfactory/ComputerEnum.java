package com.example.demo.designpattern.abstractfactory;

public enum  ComputerEnum {
    PC_COMPUTER("com.example.demo.designpattern.abstractfactory.PC"),
    SERVER_COMPUTER("com.example.demo.designpattern.abstractfactory.Server"),

    ;


    private String value;

    ComputerEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
