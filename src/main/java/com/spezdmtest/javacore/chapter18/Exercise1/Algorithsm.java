package com.spezdmtest.javacore.chapter18.Exercise1;

import java.util.ArrayList;
import java.util.TreeSet;

public class Algorithsm {
    public static TreeSet<Integer> alg(ArrayList arrayList1, ArrayList arrayList2){
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < arrayList1.size(); i++) {
            for(int j = 0; j < arrayList2.size(); j++) {
                if(arrayList1.get(i).equals(arrayList2.get(j)) == true) {
                    //System.out.println("Элемент " + i + " равен элементу " + j + " второго массива");
                treeSet.add((Integer) arrayList1.get(i));
                }
            }
        }
    return treeSet;
    }
}
