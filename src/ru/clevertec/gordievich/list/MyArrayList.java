package ru.clevertec.gordievich.list;

import ru.clevertec.gordievich.iterator.MyIterator;
import ru.clevertec.gordievich.iterator.MyIteratorImpl;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int INITIAL_CAPACITY =  10;
    private static final double RATE = 1.5;

    private Object[] array;
    private int size;
    private int maxSize = 0;

    public MyArrayList(){
        this.array = new Object[INITIAL_CAPACITY];
    }

    @Override
    public void add(T item){
        if(size + 1 > maxSize && maxSize != 0) throw new IndexOutOfBoundsException();
        if(size == array.length - 1){
            array = extendArray();
        }
        array[size++] = item;
    }

    @Override
    public void add(T item, int index) {
        if(size + 1 > maxSize && maxSize != 0) throw new IndexOutOfBoundsException();
        if(index >= size) throw new IndexOutOfBoundsException();

        T[] temp = (T[]) Arrays.copyOfRange(array, index, size);
        size = size + 1;
        if(size == array.length) {
            array = extendArray();
        }
        array[index] = item;
        for (int i = index + 1; i < size; i++) {
            array[i] = temp[i-index-1];
        }
    }

    private T[] extendArray() {
        return (T[])Arrays.copyOf(array, (int)(size * RATE));
    }

    @Override
    public T get(int index){
        return (T) array[index];
    }

    @Override
    public T remove(int index) {
        T removedElement = (T)array[index];
        if(index >= size) throw new ArrayIndexOutOfBoundsException();

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size = size - 1;
        return removedElement;
    }

    @Override
    public void set(T item, int index) {
        if(index >= size) throw new ArrayIndexOutOfBoundsException();
        array[index] = item;
    }

    @Override
    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public void addAll(MyList<? extends T> list) {
        T[] temp = (T[])list.toArray();
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
    public int find(T item) {
        return 0;
    }

    @Override
    public T[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = this.get(i);
        }
        return (T[])array;
    }

    @Override
    public void trim() {
        Object[] temp = (T[])Arrays.copyOf(array, size);
        array = temp;
    }

    @Override
    public MyIterator<T> getIterator() {
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

    private class MyIteratorImpl implements MyIterator<T> {

        private int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < size;
        }

        @Override
        public T next() {
            return get(pointer++);
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(pointer - 1);
            pointer--;
        }

        @Override
        public void addBefore(T item) {
            add(item, pointer-1);
            pointer++;
        }

        @Override
        public void addAfter(T item) {
            add(item, pointer);
            pointer++;
        }
    }

}
