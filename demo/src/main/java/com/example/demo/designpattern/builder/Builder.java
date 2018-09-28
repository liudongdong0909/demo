package com.example.demo.designpattern.builder;

public abstract class Builder {

    protected Computer computer = new Computer();

    public Computer createComputer() {
        return computer;
    }

    public abstract Builder buildBrand();

    public abstract Builder buildCPU();

    public abstract Builder buildHardDisk();

    public abstract Builder buildMemory();


}
