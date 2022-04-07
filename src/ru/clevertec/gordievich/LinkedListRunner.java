package ru.clevertec.gordievich;

import ru.clevertec.gordievich.list.MyIterator;
import ru.clevertec.gordievich.list.impl.MyArrayList;
import ru.clevertec.gordievich.list.impl.MyLinkedList;
import ru.clevertec.gordievich.list.MyList;

public class LinkedListRunner {
    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(1);
        myLinkedList.add(2);
        //myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(5);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();


        myLinkedList.add(3, 2);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

        MyList<Integer> myList2 = new MyArrayList<>();
        myList2.add(6);
        myList2.add(7);

        myLinkedList.addAll(myList2);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

        myLinkedList.remove(2);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

        myLinkedList.set(10, 3);
        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

//        myLinkedList.clear();
//        System.out.println("After cleaning: ");
//        for (int i = 0; i < myLinkedList.size(); i++) {
//            System.out.print(myLinkedList.get(i) + " ");
//        }
//        System.out.println();

        myLinkedList.setMaxSize(20);

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

        System.out.println("Found element index: " + myLinkedList.find(2));

        MyIterator<Integer> myIterator = myLinkedList.getIterator();
        while (myIterator.hasNext()) {
            int element = myIterator.next();
            if(element == 1) myIterator.addBefore(0);
            else if(element == 2) myIterator.addAfter(3);
        }

        for (int i = 0; i < myLinkedList.size(); i++) {
            System.out.print(myLinkedList.get(i) + " ");
        }
        System.out.println();

//        while(myIterator.hasNext()) {
//            System.out.println("element: " + myIterator.next());
//        }

    }
}
