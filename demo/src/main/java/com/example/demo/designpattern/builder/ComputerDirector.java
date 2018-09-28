package com.example.demo.designpattern.builder;

public class ComputerDirector {

    public static Computer getComputer(Builder builder) {

        return builder.buildBrand()
                .buildCPU()
                .buildHardDisk()
                .buildMemory()
                .createComputer();
    }

}
