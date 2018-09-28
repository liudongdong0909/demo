package com.example.demo.designpattern.template;

public abstract class HouseTemplate {

    public final void buildHouse() {
        this.buildFoundation();
        this.buildPillars();
        this.buildWalls();
        this.buildWindows();
        System.out.println("House is built.");
    }

    private final  void buildWindows() {
        System.out.println("final = Building Glass Wiondows");
    }

    public abstract void buildWalls();

    public abstract void buildPillars();

    private final void buildFoundation(){
        System.out.println("final = Building Foundation with cement, iron rods and sand");
    }
}
