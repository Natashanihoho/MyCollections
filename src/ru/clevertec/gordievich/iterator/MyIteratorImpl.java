package ru.clevertec.gordievich.iterator;

import ru.clevertec.gordievich.list.MyList;

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
    public void addBefore() {

    }

    @Override
    public void addAfter() {

    }
}
