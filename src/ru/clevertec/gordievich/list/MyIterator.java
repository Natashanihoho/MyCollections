package ru.clevertec.gordievich.list;


public interface MyIterator<T> {

    boolean hasNext();

    T next();

    void remove();

    void addBefore(T item);

    void addAfter(T item);

}
