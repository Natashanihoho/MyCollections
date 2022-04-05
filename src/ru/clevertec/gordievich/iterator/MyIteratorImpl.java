package ru.clevertec.gordievich.iterator;

public class MyIteratorImpl<T> implements MyIterator {

    private int marker;

    public MyIteratorImpl() {
    }

    @Override
    public boolean hasNext() {
        return false;
        //return marker != size;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void addBefore(Object item) {

    }

    @Override
    public void addAfter(Object item) {

    }
}
