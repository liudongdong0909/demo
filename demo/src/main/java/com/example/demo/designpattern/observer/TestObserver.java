package com.example.demo.designpattern.observer;

import java.io.File;
import java.io.FileFilter;

public class TestObserver {

    public static void main(String[] args) {

        File[] files = new File("").listFiles(File::isHidden);

        MyTopic myTopic = new MyTopic();

        Observer observer1 = new MyTopicSubscriber("observer1");
        Observer observer2 = new MyTopicSubscriber("observer2");
        Observer observer3 = new MyTopicSubscriber("observer3");

        // 观察者注册到被观察者
        myTopic.register(observer1);
        myTopic.register(observer2);
        myTopic.register(observer3);

        // 观察者订阅被观察者
        observer1.setSubject(myTopic);
        observer2.setSubject(myTopic);
        observer3.setSubject(myTopic);

        observer1.update();

        myTopic.postMessage("hello world !");

    }
}
