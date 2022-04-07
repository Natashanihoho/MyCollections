package ru.clevertec.gordievich.list;


public interface MyList<E> {

    void add(E item);

    void add(E item, int index);

    void addAll(MyList<? extends E> list);

    E get(int index);

    E remove(int index);

    void set(E item, int index);

    void clear();

    void setMaxSize(int maxSize);

    int find(E item);

    E[] toArray();

    void trim();

    MyIterator<E> getIterator();

    int size();

    boolean isEmpty();
}
