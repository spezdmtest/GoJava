package com.spezdmtest.javacore.chapter18.Exercise1;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class AlogorithsmDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(6);
        arrayList1.add(4);
        arrayList1.add(6);
        arrayList1.add(8);
        arrayList1.add(1);arrayList1.add(100);
        arrayList1.add(-100);


        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(3);
        arrayList2.add(8);
        arrayList2.add(76544);
        arrayList2.add(-42);
        arrayList2.add(100);
        arrayList2.add(1);

        System.out.println("Входные данные: ");
        System.out.println(arrayList1);
        System.out.println(arrayList2);
        System.out.println("Результат: ");
        System.out.println(Algorithsm.alg(arrayList1,arrayList2));
    }
}
