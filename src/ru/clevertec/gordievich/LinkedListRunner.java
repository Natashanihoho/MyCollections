package ru.clevertec.gordievich;

import ru.clevertec.gordievich.list.MyArrayList;
import ru.clevertec.gordievich.list.MyLinkedList;
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
//        for (int i = 0; i < myLinkedList.size(); i++) {
//            System.out.print("After cleaning: " + myLinkedList.get(i) + " ");
//        }
//        System.out.println();
    }
}
