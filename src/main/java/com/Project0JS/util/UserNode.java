package com.Project0JS.util;

import com.Project0JS.model.User;

public class UserNode {
    private User u;
    private UserNode next;
    private UserNode previous;

    public UserNode(User u) {
        this.u = u;
        this.next = null;
        this.previous = null;
    }
    public UserNode(User u, UserNode next, UserNode previous) {
        this.u = u;
        this.next = next;
        this.previous = previous;
    }

    public User getU() {
        return u;
    }

    public UserNode getNext() {
        return next;
    }

    public UserNode getPrevious() {
        return previous;
    }

    public void setU(User u) {
        this.u = u;
    }

    public void setNext(UserNode next) {
        this.next = next;
    }

    public void setPrevious(UserNode previous) {
        this.previous = previous;
    }
}
