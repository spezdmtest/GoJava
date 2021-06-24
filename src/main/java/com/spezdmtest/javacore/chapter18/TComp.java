package com.spezdmtest.javacore.chapter18;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TComp implements Comparator <String> {
    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;

        i = aStr.lastIndexOf(' ' );
        j = bStr.lastIndexOf(' ');
        k = aStr.substring(i).compareTo(bStr.substring(j));
        if (k==0)
             return aStr.compareTo(bStr);
        else
                return k;
        }
}
class TreeMapDemo2 {
    public static void main(String[] args) {
        TreeMap<String,Double> tm = new TreeMap<String,Double>(new TComp());
        tm.put("Джон Доу", 3434.34);
        tm.put("Том Смит", 123.22);
        tm.put("Джейн Бейкер", 1378.00);
        tm.put("Тод Халл", 99.22);
        tm.put("Ральф Смит", -19.08);

        Set<Map.Entry<String,Double>> set = tm.entrySet();

        for(Map.Entry<String,Double> me : set ) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
        System.out.println();
        double balance = tm.get("Джон Доу");
        tm.put("Джон Доу", balance + 1000);
        System.out.println("Новый остаток на счете Джона Доу: " + tm.get("Джон Доу"));
    }
}
