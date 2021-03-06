package com.Project0JS.util;

public interface DaoInterface<T, I> {
    int create(T t);

    int save(T t);

    GenericArrayList<T> getAll();

    boolean remove(I id);

    boolean update(T t);
}
