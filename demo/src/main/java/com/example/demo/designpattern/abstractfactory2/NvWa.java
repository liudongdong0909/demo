package com.example.demo.designpattern.abstractfactory2;

public class NvWa {

    public static void main(String[] args) {
        HumanFactory maleFactory = new MaleHumanFactory();

        HumanFactory femaleFactory = new FemaleHumanFactory();

        Human maleBlackHuman = maleFactory.createBlackHuman();
        Human maleWhiteHuman = maleFactory.createWhiteHuman();
        Human maleYellowHuman = maleFactory.createYellowHuman();

        Human femaleYellowHuman = femaleFactory.createYellowHuman();
        Human femaleWhiteHuman = femaleFactory.createWhiteHuman();
        Human femaleBlackHuman = femaleFactory.createBlackHuman();

        // TODO
    }

}
