package com.spezdmtest.javacore.chapter15;

import org.w3c.dom.ls.LSOutput;

interface StringFunc2 {
    String func(String n);
}
class MyStringOps2 {
    String strReverse(String str) {
        String result = "";
        int i;
        for(i = str.length() -1; i >= 0; i--)
            result += str.charAt(i);
        return result;
    }
}
public class MethodRefDemo2 {
static String stringOp(StringFunc sf, String s) {
    return sf.func(s);
   }
    public static void main(String[] args) {
        String in_Str = "Лямда-выражения повышают эффективность Java";
        String outStr;
        MyStringOps2 strOps = new MyStringOps2();
        outStr = stringOp(strOps::strReverse, in_Str);
        System.out.println("Исходная строка: " + in_Str);
        System.out.println("Обращеная строка: " + outStr);
    }
}
