package com.spezdmtest.javacore.module1_2.Exercise1;

import java.util.LinkedHashSet;

public class CompareCollectionsDemo {
    public static void main(String[] args) {
        LinkedHashSet<Integer> list1 = new LinkedHashSet<>();
        list1.add(6);
        list1.add(4);
        list1.add(6);
        list1.add(8);
        list1.add(1);
        list1.add(100);
        list1.add(-100);


        LinkedHashSet<Integer> list2 = new LinkedHashSet<>();
        list2.add(3);
        list2.add(8);
        list2.add(76544);
        list2.add(-42);
        list2.add(100);
        list2.add(1);

        System.out.println("Входные данные: ");
        System.out.println(list1);
        System.out.println(list2);
        System.out.println("Результат: ");

        CompareCollections<Integer> collections = new CompareCollections<>();
        System.out.println(collections.compareCollections(list1,list2));
    }
}
