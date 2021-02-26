package com.Project0JS.util;

/*
Credit to Java Gym App gym linked list team for this class
 */

import com.Project0JS.model.User;

public class UserLinkedList {

    UserNode head;
    UserNode tail;
    private int size = 0;

    public User get(Object s) throws ClassCastException {
        if (!(s instanceof String)) {
            throw new ClassCastException("Expected a username (String), got " + s.getClass());
        }
        if (head == null) {
            return null;
        }
        if (((String) s).equals((head.getU().getUserName()))) {
            return head.getU();
        } else if (head.getNext()== null) {
            return null;
        }
        return get(s, this.head.getNext());
    }

    private User get(Object s, UserNode n) {
        if (n == null) {
            return null;
        }
        if (((String) s).equals((n.getU().getUserName()))) {
            return n.getU();
        } else if (n.getNext()== null) {
            return null;
        }
        return get(s, n.getNext());
    }

    public void add(User u) throws Exception {
        if (head == null) {
            head = new UserNode(u);
            tail = head;
        } else {
            if (u.getUserName().equals(head.getU().getUserName())) {
                throw new IllegalArgumentException("User Already Exists");
            }
            UserNode n = head;
            UserNode previous = null;
            while (n.getNext() != null) {
                if (n.getU().getUserName().equals(u.getUserName())) {
                    throw new IllegalArgumentException("User Already Exists");
                }
                n = n.getNext();
            }
            UserNode newNode = new UserNode(u);
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
        if (!(o instanceof User)) {
            throw new ClassCastException("Expected a User, got " + o.getClass());
        }
        if (head == null) {
            return;
        }
        if (((User) o).equals((head.getU()))) {
            head = head.getNext();
            if (head!=null) {
                head.setPrevious(null);
            }
            size--;
            return;
        }
        remove(o, this.head.getNext());

    }
    private void remove(Object o, UserNode n) {
        if (n == null) {
            return;
        }
        if (((User) o).equals((n.getU()))) {
            n.getPrevious().setNext(n.getNext());
            n.getNext().setPrevious(n.getPrevious());
            size--;
        } else {
            remove(o, n.getNext());
        }

    }
    public User next() {
        return null;
    }

    public User previous() {
        return null;
    }

    public String toString() {
        if (head == null) {
            return "Empty List";
        }
        StringBuilder returnBuilder = new StringBuilder();
        UserNode n = head;
        do {
            returnBuilder.append(n.getU().getUserName() + "\n");
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

    public int indexOf(User u) {
        int returnvalue = 0;
        if (head ==null) {
            return -1;
        }
        UserNode n = head;
        while (n!=null) {
            returnvalue++;
            if (n.getU().equals(u)) {
                return returnvalue;
            }
            n=n.getNext();
        }
        return -1;
    }
}