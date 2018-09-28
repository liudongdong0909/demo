package com.example.demo.designpattern.abstractfactory;

public class TestAbstratFactory {

    public static void main(String[] args) {
        testAbstractFactory();
    }

    private static void testAbstractFactory() {

        Computer pc = ComputerFactory.getComputer(new PCFactory("2G", "500G", "2.5G HZ"));

        Computer server = ComputerFactory.getComputer(new ServerFactory("32G", "10T", "4G HZ"));

        System.out.println("PC => " + pc.toString());

        System.out.println("SERVER => " + server.toString());
    }
}
