package ru.clevertec.gordievich;

import ru.clevertec.gordievich.list.MyArrayList;
import ru.clevertec.gordievich.list.MyList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(7);
        myArrayList.add(8);
        myArrayList.add(9);
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.add(12);
        System.out.println("Size: " + myArrayList.size());
        System.out.println("1 element: " + myArrayList.get(0));
        System.out.println("2 element: " + myArrayList.get(1));
        System.out.println("12 element: " + myArrayList.get(11));
        int a = myArrayList.remove(5);
        System.out.println("Removed element: " + a);
        System.out.println("List after removing: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
        System.out.println();
        myArrayList.set(6, 5);
        System.out.println("Recovered list: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
//        System.out.println();
//        System.out.println("Clearing...");
//        myArrayList.clear();
//        System.out.println("List: ");
//        for (int i = 0; i < myArrayList.size(); i++) {
//            System.out.print(myArrayList.get(i) + " ");
//        }

        System.out.println();
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(13);
        myList.add(14);
        myList.add(15);
        myArrayList.addAll(myList);

        System.out.println("List after adding collections: ");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.print(myArrayList.get(i) + " ");
        }
    }
}
