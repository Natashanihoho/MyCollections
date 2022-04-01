package ru.clevertec.gordievich.iterator;

public interface MyIterator<T> {

    boolean hasNext();

    T next();

    void remove();

    void addBefore();

    void addAfter();

}
