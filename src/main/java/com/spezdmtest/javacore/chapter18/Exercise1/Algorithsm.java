package com.spezdmtest.javacore.chapter18.Exercise1;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Algorithsm <T> {
    public TreeSet<T> mergeCollection(LinkedHashSet<T> list1, LinkedHashSet<T> list2) {
        TreeSet<T> treeSet = new TreeSet<>();
//        for (int i = 0; i < arrayList1.size(); i++) {
//            for(int j = 0; j < arrayList2.size(); j++) {
//                if(arrayList1.get(i).equals(arrayList2.get(j)) == true) {
//                    //System.out.println("Элемент " + i + " равен элементу " + j + " второго массива");
//                treeSet.add((Integer) arrayList1.get(i));
//                }
//            }
//        }
        for (T l1 : list1) {
            for (T l2 : list2) {
                if (l1.equals(l2)) {
                    treeSet.add(l1);
                }
            }
        }
            return treeSet;
        }
    }

