package ru.clevertec.gordievich.list;

import ru.clevertec.gordievich.iterator.MyIterator;

import java.util.LinkedList;

public class MyLinkedList <T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static class Node<T> {
        private Node<T> prev;
        private Node<T> next;
        private T item;

        public Node(T item) {
            this.item = item;
        }
    }

    @Override
    public void add(T item) {
        Node node = new Node(item);
        if(first == null) {
            node.prev = null;
            node.next = null;
            first = last = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
    }

    @Override
    public void add(T item, int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
        Node node = new Node(item);
        Node nextNode = first;
        if(first == null || index == size) {
            add(item);
        } else {
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.next;
            }
            node.prev = nextNode.prev;
            node.next = nextNode;
            nextNode.prev.next = node;
            nextNode.prev = node;
        }
        size++;
    }

    @Override
    public void addAll(MyList<? extends T> list) {
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        Node node = first;
        if(index >= size || index < 0) throw new IndexOutOfBoundsException();
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (T)node.item;
    }

    @Override
    public T remove(int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
        Node removedNode = first;
        for (int i = 0; i < index; i++) {
            removedNode = removedNode.next;
        }
        Node prevNode = removedNode.prev;
        Node nextNode = removedNode.next;
        if(nextNode == null) {
            prevNode.next = null;
        }
        else if(size != 1) {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        size--;
        return (T)removedNode.item;
    }

    @Override
    public void set(T item, int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException();
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.item = item;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size - 1; i++) {
            remove(i);
        }
    }

    @Override
    public void setMaxSize(int maxSize) {

    }

    @Override
    public int find(T item) {
        return 0;
    }

    @Override
    public T[] toArray() {
        return null;
    }

    @Override
    public void trim() {

    }

    @Override
    public MyIterator<T> getIterator() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
