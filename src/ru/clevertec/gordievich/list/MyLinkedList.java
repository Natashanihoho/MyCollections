package ru.clevertec.gordievich.list;

import ru.clevertec.gordievich.iterator.MyIterator;

public class MyLinkedList <T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;
    private int maxSize = 0;

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
        if(maxSize != 0 && size + 1 > maxSize) throw new IndexOutOfBoundsException("Adding error: the size exceeds the maximum allowable value");

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
        if(maxSize != 0 && size + 1 > maxSize) {
            System.out.println("size: " + size);
            System.out.println("maxSize: " + maxSize);
            throw new IndexOutOfBoundsException("Adding by index error: the size exceeds the maximum allowable value");
        }
        if(index > size || index < 0) throw new IndexOutOfBoundsException("Adding by index error: index > size || index < 0");

        if(index == 0 && index != size){
            Node node = new Node(item);
            Node nextNode = first;
            nextNode.prev = node;
            node.next = nextNode;
            first = node;
            size++;
        }
        else if(index == size) {
            add(item);
        } else {
            Node node = new Node(item);
            Node nextNode = first;
            Node prevNode;
            for (int i = 0; i < index; i++) {
                nextNode = nextNode.next;
            }
            prevNode = nextNode.prev;

            node.prev = prevNode;
            node.next = nextNode;
            prevNode.next = node;
            nextNode.prev = node;
            size++;
        }

    }

    @Override
    public void addAll(MyList<? extends T> list) {
        if(maxSize != 0 && size + list.size() > maxSize) throw new IndexOutOfBoundsException("Adding of collection error: the size exceeds the maximum allowable value");
        for (int i = 0; i < list.size(); i++) {
            add(list.get(i));
        }
    }

    @Override
    public T get(int index) {
        Node node = first;
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Getting error: index >= size || index < 0");
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return (T)node.item;
    }

    @Override
    public T remove(int index) {
        if(index >= size || index < 0) throw new IndexOutOfBoundsException("Removing error: index >= size || index < 0");

        Node removedNode = first;
        for (int i = 0; i < index; i++) {
            removedNode = removedNode.next;
        }
        Node prevNode = removedNode.prev;
        Node nextNode = removedNode.next;
        if(index == 0 || index == size - 1) {
            if(prevNode == null){
                first = nextNode;
                if(nextNode != null) nextNode.prev = null;
            }
            if(nextNode == null) {
                last = prevNode;
                if(prevNode != null) prevNode.next = null;
            }
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }
        size--;
        return (T)removedNode.item;
    }

    @Override
    public void set(T item, int index) {
        if(index > size || index < 0) throw new IndexOutOfBoundsException("Setting error: index >= size || index < 0");
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.item = item;
    }

    @Override
    public void clear() {
        if(!isEmpty()) {
            for (int i = 0; i < size - 1; i++) {
                remove(i);
            }
            size = 0;
        }
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        while (size > maxSize) {
            remove(size - 1);
            size--;
        }
    }

    @Override
    public int find(T item) {
        if (!isEmpty()) {
            for (int index = 0; index < size; index++) {
                if(get(index) == item) return index;
            }
        }
        return -1;
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

    }

    @Override
    public MyIterator<T> getIterator() {
        return new MyIteratorImpl();
    }

    @Override
    public int size() {
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
            MyLinkedList.this.remove(pointer - 1);
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
