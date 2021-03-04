package com.Project0JS.util;

//Credit https://www.journaldev.com/110/how-to-implement-arraylist-with-array-in-java for the original implementation,
// generics added by me

import java.util.Arrays;

public class GenericArrayList<T> {

    private static final int SIZE_FACTOR = 5;

    private T[] data;

    private int index;

    private int size;

    public GenericArrayList() {
        this.data = (T[])new Object[SIZE_FACTOR];
        this.size = SIZE_FACTOR;
    }

    public void add(T obj) {
        if (this.index == this.size - 1) {
            increaseSizeAndReallocate();
        }
        data[this.index] = obj;
        this.index++;

    }

    private void increaseSizeAndReallocate() {
        this.size = this.size + SIZE_FACTOR;
        T[] newData = (T[])new Object[this.size];
        System.arraycopy(data, 0, newData, 0, data.length);
        this.data = newData;
    }

    public T get(int i) {
        return this.data[i];
    }

    public void remove(int i) {
        if (this.data.length - 1 - i >= 0) System.arraycopy(data, i + 1, data, i, this.data.length - 1 - i);
        this.index--;
    }


    /*
        public int getSize() {
        return size;
    }
     */

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "GenericArrayList{" +
                "data=" + Arrays.toString(data) +
                ", index=" + index +
                ", size=" + size +
                '}';
    }
}

