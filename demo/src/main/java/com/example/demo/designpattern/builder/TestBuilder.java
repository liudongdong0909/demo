package com.example.demo.designpattern.builder;

public class TestBuilder {

    public static void main(String[] args) {

        Computer computer = ComputerDirector.getComputer(new MacComputerBuilder());
        System.out.println(computer.toString());
    }
}
