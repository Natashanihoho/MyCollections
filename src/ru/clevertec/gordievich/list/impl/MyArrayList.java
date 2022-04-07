package ru.clevertec.gordievich.list.impl;


import ru.clevertec.gordievich.list.MyIterator;
import ru.clevertec.gordievich.list.MyList;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int INITIAL_CAPACITY =  10;
    private static final double RATE = 1.5;

    private Object[] array;
    private int size;
    private int maxSize = 0;

    public MyArrayList(){
        this.array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(E item){
        if(size + 1 > maxSize && maxSize != 0) throw new IndexOutOfBoundsException();
        if(size == array.length - 1){
            array = extendArray();
        }
        array[size++] = item;
    }

    @Override
    public void add(E item, int index) {
        if(size + 1 > maxSize && maxSize != 0) throw new IndexOutOfBoundsException();
        if(index >= size) throw new IndexOutOfBoundsException();
        size = size + 1;
        if(size > array.length) {
            array = extendArray();
        }
        for (int i = size - 1; i > index ; i--) {
            array[i] = array[i-1];
        }
        array[index] = item;
    }

    private E[] extendArray() {
        return (E[])Arrays.copyOf(array, (int)(size * RATE));
    }

    @Override
    public E get(int index){
        return (E) array[index];
    }

    @Override
    public E remove(int index) {
        E removedElement = (E)array[index];
        if(index >= size) throw new ArrayIndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size = size - 1;
        return removedElement;
    }

    @Override
    public void set(E item, int index) {
        if(index >= size) throw new ArrayIndexOutOfBoundsException();
        array[index] = item;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void addAll(MyList<? extends E> list) {
        E[] temp = (E[])list.toArray();
        if(size + temp.length > maxSize && maxSize != 0) throw new IndexOutOfBoundsException();
        if(size + temp.length > array.length) {
            array = extendArray();
        }
        for (int i = size; i < size + temp.length; i++) {
            array[i] = temp[i - size];
        }
        size = size + temp.length;
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        while(size > maxSize) {
            remove(size - 1);
            size--;
        }
    }

    @Override
    public int find(E item) {
        return 0;
    }

    @Override
    public E[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = this.get(i);
        }
        return (E[])array;
    }

    @Override
    public void trim() {
        Object[] temp = (E[])Arrays.copyOf(array, size);
        array = temp;
    }

    @Override
    public MyIterator<E> getIterator() {
        return new MyIteratorImpl();
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class MyIteratorImpl implements MyIterator<E> {

        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        @Override
        public E next() {
            return get(pointer++);
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(pointer - 1);
            pointer--;
        }

        @Override
        public void addBefore(E item) {
            add(item, pointer-1);
            pointer++;
        }

        @Override
        public void addAfter(E item) {
            add(item, pointer);
            pointer++;
        }
    }

}
