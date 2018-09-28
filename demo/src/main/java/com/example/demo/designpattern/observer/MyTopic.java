package com.example.demo.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

    private List<Observer> observerList;

    private String message;

    private Boolean changed;

    private final Object MUTEX = new Object();

    public MyTopic() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void register(Observer observer) {
        if (null == observer) {
            throw new NullPointerException("Null Observer");
        }
        synchronized (MUTEX) {
            if (!observerList.contains(observer)) {
                observerList.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (MUTEX){
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        List<Observer> localObserverList = null;
        synchronized (MUTEX){
            if (!changed){
                return;
            }
            localObserverList = new ArrayList<>(this.observerList);
            this.changed = false;
        }

        for (Observer observer : localObserverList) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return this.message;
    }

    public void postMessage(String message){
        System.out.println("Message Posted to Topic :" + message);

        this.message = message;
        this.changed = true;
        this.notifyObservers();
    }
}
