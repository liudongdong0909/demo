package com.example.demo.designpattern.abstractfactory2;

public class MaleHumanFactory extends AbstractHumanFactory {

    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YELLOW_MALE_HUMAN);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WHITE_MALE_HUMAN);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BLACK_MALE_HUMAN);
    }
}
