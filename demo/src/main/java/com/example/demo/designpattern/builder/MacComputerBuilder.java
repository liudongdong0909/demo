package com.example.demo.designpattern.builder;

public class MacComputerBuilder extends Builder {

    @Override
    public Builder buildBrand() {
        super.computer.setBrand("MAC");
        return this;
    }

    @Override
    public Builder buildCPU() {
        super.computer.setCpu("i7");
        return this;
    }

    @Override
    public Builder buildHardDisk() {
        super.computer.setHardDisk("500G");
        return this;
    }

    @Override
    public Builder buildMemory() {
        super.computer.setMemory("16G");
        return this;
    }

}
