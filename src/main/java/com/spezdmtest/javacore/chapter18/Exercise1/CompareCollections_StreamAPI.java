package com.spezdmtest.javacore.chapter18.Exercise1;

import java.util.List;
import java.util.stream.Collectors;

public class CompareCollections_StreamAPI<T> {
    public static List<Integer> getList1() {
        return List.of(6, 4, 6, 8, 1, 100, -100);
    }
    public static List<Integer> getList2() {
        return List.of(3, 8, 76544, -42, 100, 1);
    }
    public static List<Integer> compareCollections(List<Integer> list1, List<Integer> list2) {
        return   list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
    public static List<Integer> sortCollection(List<Integer> list) {
        return list.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public static void printCollection(List<Integer> list) {
        list.forEach(System.out::print);
    }
}

