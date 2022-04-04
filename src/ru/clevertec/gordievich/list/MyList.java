package ru.clevertec.gordievich.list;

import ru.clevertec.gordievich.iterator.MyIterator;


public interface MyList<T> {

    void add(T item);

    void add(T item, int index);

    void addAll(MyList<? extends T> list);

    T get(int index);

    T remove(int index);

    void set(T item, int index);

    void clear();

    void setMaxSize(int maxSize);

    int find(T item);

    T[] toArray();

    void trim();

    MyIterator<T> getIterator();

    int size();

    boolean isEmpty();
}
