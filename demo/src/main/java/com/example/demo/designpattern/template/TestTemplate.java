package com.example.demo.designpattern.template;

public class TestTemplate {

    public static void main(String[] args) {
        HouseTemplate houseTemplate = new WoodenHouse();
        houseTemplate.buildHouse();
        System.out.println("======================");
        houseTemplate = new GlassHouse();
        houseTemplate.buildHouse();
    }
}
