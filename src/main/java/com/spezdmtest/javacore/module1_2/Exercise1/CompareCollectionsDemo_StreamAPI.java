package com.spezdmtest.javacore.module1_2.Exercise1;

import java.util.List;

public class CompareCollectionsDemo_StreamAPI {
    public static List<Integer> getList1() {
        return List.of(6, 4, 6, 8, 1, 100, -100);
    }
    public static List<Integer> getList2() {
        return List.of(3, 8, 76544, -42, 100, 1);
    }
    public static void main(String[] args) {
        List<Integer> list1 = getList1();
        List<Integer> list2 = getList2();

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