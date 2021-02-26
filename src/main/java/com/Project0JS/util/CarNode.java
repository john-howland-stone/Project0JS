package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarNode {
    private Car c;
    private CarNode next;
    private CarNode previous;

    public CarNode(Car c) {
        this.c = c;
        this.next = null;
        this.previous = null;
    }
    public CarNode(Car c, CarNode next, CarNode previous) {
        this.c = c;
        this.next = next;
        this.previous = previous;
    }

    public Car getC() {
        return c;
    }

    public CarNode getNext() {
        return next;
    }

    public CarNode getPrevious() {
        return previous;
    }

    public void setC(Car c) {
        this.c = c;
    }

    public void setNext(CarNode next) {
        this.next = next;
    }

    public void setPrevious(CarNode previous) {
        this.previous = previous;
    }
}
