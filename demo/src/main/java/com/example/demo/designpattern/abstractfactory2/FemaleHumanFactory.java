package com.example.demo.designpattern.abstractfactory2;

public class FemaleHumanFactory extends AbstractHumanFactory {
    @Override
    public Human createYellowHuman() {
        return super.createHuman(HumanEnum.YELLOW_FEMALE_HUMAN);
    }

    @Override
    public Human createWhiteHuman() {
        return super.createHuman(HumanEnum.WHITE_FEMALE_HUMAN);
    }

    @Override
    public Human createBlackHuman() {
        return super.createHuman(HumanEnum.BLACK_FEMALE_HUMAN   );
    }
}
