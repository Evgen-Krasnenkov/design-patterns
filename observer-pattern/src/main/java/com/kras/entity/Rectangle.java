package com.kras.entity;

import com.kras.Observable;
import com.kras.Observer;
import com.kras.event.RectangleEvent;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Rectangle implements Observable {
    private int id;
    private double sideA;
    private double sideB;
    private final List<Observer> observers = new ArrayList<>();
    private RectangleEvent event;

    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        this.event = new RectangleEvent(this);
        notifyObserver();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        this.event = new RectangleEvent(this);
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> observer.handleEvent(this.event));
    }
}
