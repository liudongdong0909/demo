package com.example.demo.designpattern.builder;


public class DellComputerBuilder extends Builder {
    @Override
    public Builder buildBrand() {
        super.computer.setBrand("DELL");
        return this;
    }

    @Override
    public Builder buildCPU() {
        super.computer.setCpu("i5");
        return this;
    }

    @Override
    public Builder buildHardDisk() {
        super.computer.setHardDisk("1T");
        return this;
    }

    @Override
    public Builder buildMemory() {
        super.computer.setMemory("8G");
        return this;
    }
}
