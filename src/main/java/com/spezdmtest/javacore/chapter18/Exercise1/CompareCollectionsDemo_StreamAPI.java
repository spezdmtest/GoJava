package com.spezdmtest.javacore.chapter18.Exercise1;

import java.util.List;

public class CompareCollectionsDemo_StreamAPI {
    public static void main(String[] args) {
        List<Integer> list1 = CompareCollections_StreamAPI.getList1();
        List<Integer> list2 = CompareCollections_StreamAPI.getList2();

        System.out.println("Входные данные: ");
        System.out.println(list1);
        System.out.println(list2);

        //Filter
        System.out.println("Результат: ");
        List<Integer> result = CompareCollections_StreamAPI.compareCollections(list1,list2);
        CompareCollections_StreamAPI.printCollection(result);
        System.out.println();
        //Sorting
        System.out.println("Сортировка: ");
        List<Integer> resultSort= CompareCollections_StreamAPI.sortCollection(result);
        CompareCollections_StreamAPI.printCollection(resultSort);

    }
}