package com.example.demo.designpattern.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

public class TestCGLib {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new MyMethodInterceptor());

        Student student  = (Student) enhancer.create();
        student.sayHello();
        student.study();
        student.speak();
        student.run();

    }
}
