package com.spezdmtest.javacore.chapter15;
interface StringFunc_2 {
    String func(String n);
}

class MyStringOps {
    static String strRevers (String str) {
        String result = "";
        int i;
        for(i = str.length()-1; i >= 0; i--)
            result += str.charAt(i);

        return result;
    }
}

public class MethodRefDemo {
    static String stringOp(StringFunc_2 sf, String s)  {
        return sf.func(s);
    }
    public static void main(String[] args) {
        String in_Str = "Лямда-выражения повышают эффективность Java";
        String outStr;

        outStr = stringOp(MyStringOps::strRevers,in_Str);

        System.out.println("Исходная строка: " + in_Str);
        System.out.println("Обращенная строка: " +outStr);
    }
}