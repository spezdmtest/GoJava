package com.spezdmtest.javacore.chapter18.Exercise2;

public class AnalizatorDemo {
    public static void main(String[] args) {
        System.out.println(Analizator.analizator("[({})]"));
        System.out.println(Analizator.analizator("[(){}]"));
    }
}