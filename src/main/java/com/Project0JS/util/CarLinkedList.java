package com.Project0JS.util;

import com.Project0JS.model.Car;

public class CarLinkedList {

    CarNode head;
    CarNode tail;
    private int size = 0;

    public Car get(Object s) throws ClassCastException {
        if (!(s instanceof String)) {
            throw new ClassCastException("Expected a Carname (String), got " + s.getClass());
        }
        if (head == null) {
            return null;
        }
        if (((String) s).equals((head.getC().getMake()))) {
            return head.getC();
        } else if (head.getNext()== null) {
            return null;
        }
        return get(s, this.head.getNext());
    }

    private Car get(Object s, CarNode n) {
        if (n == null) {
            return null;
        }
        if (((String) s).equals((n.getC().getMake()))) {
            return n.getC();
        } else if (n.getNext()== null) {
            return null;
        }
        return get(s, n.getNext());
    }

    public void add(Car u) throws Exception {
        if (head == null) {
            head = new CarNode(u);
            tail = head;
        } else {
            if (u.getMake().equals(head.getC().getMake())) {
                throw new IllegalArgumentException("Car Already Exists");
            }
            CarNode n = head;
            CarNode previous = null;
            while (n.getNext() != null) {
                if (n.getC().getMake().equals(u.getMake())) {
                    throw new IllegalArgumentException("Car Already Exists");
                }
                n = n.getNext();
            }
            CarNode newNode = new CarNode(u);
            newNode.setPrevious(n);
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void remove(Object o) {
        if (!(o instanceof Car)) {
            throw new ClassCastException("Expected a Car, got " + o.getClass());
        }
        if (head == null) {
            return;
        }
        if (((Car) o).equals((head.getC()))) {
            head = head.getNext();
            if (head!=null) {
                head.setPrevious(null);
            }
            size--;
            return;
        }
        remove(o, this.head.getNext());

    }
    private void remove(Object o, CarNode n) {
        if (n == null) {
            return;
        }
        if (((Car) o).equals((n.getC()))) {
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
            size--;
        } else {
            remove(o, n.getNext());
        }

    }
    public Car next() {
        return null;
    }

    public Car previous() {
        return null;
    }

    public String toString() {
        if (head == null) {
            return "Empty List";
        }
        StringBuilder returnBuilder = new StringBuilder();
        CarNode n = head;
        do {
            returnBuilder.append(n.getC().getMake() + "\n");
            n = n.getNext();
        } while(n != null);
        return returnBuilder.toString();
    }

    public boolean isEmpty() {
        return head==null;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public void order() {

    }

    public int indexOf(Car u) {
        int returnvalue = 0;
        if (head ==null) {
            return -1;
        }
        CarNode n = head;
        while (n!=null) {
            returnvalue++;
            if (n.getC().equals(u)) {
                return returnvalue;
            }
            n=n.getNext();
        }
        return -1;
    }

    public Car[] toArray() {
        if (head == null) {
            return null;
        }
        Car[] returnArray = new Car[size];
        CarNode n = head;
        int index = 0;
        do {
            returnArray[index] = n.getC();
            n = n.getNext();
            index++;
        } while(n != null);
        return returnArray;
    }
}