package com.example.demo.designpattern.abstractfactory2;

public enum HumanEnum {

    //把世界上所有人类型都定义出来
    YELLOW_MALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractYellowMaleHuman"),
    YELLOW_FEMALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractYellowFemaleHuman"),
    WHITE_FEMALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractWhiteFemaleHuman"),
    WHITE_MALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractWhiteMaleHuman"),
    BLACK_FEMALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractBlackFemaleHuman"),
    BLACK_MALE_HUMAN("com.example.demo.designpattern.abstractfactory2.AbstractBlackMaleHuman");

    private String value;

    HumanEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
