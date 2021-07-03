package com.spezdmtest.javacore.chapter18.Exercise2;
import java.util.ArrayDeque;

public class Analizator{

    static String analizator(String str) {
        ArrayDeque<Character> bracket = new ArrayDeque<>();
        String result;
        char element;
        for (int i = 0; i < str.length(); i++) {
            element = str.charAt(i);
            if (element == '{' || element == '[' || element == '(')
                bracket.push(element);
            if ((!bracket.isEmpty()) && (element == '}') && (bracket.peek() == '{'))
                bracket.pop();
            else if (element == '}' && (bracket.peek() != '{'))
                break;
            if ((!bracket.isEmpty()) && (element == ']') && (bracket.peek() == '['))
                bracket.pop();
            else if (element == ']' && (bracket.peek() != '['))
                break;
            if ((!bracket.isEmpty()) && (element == ')') && (bracket.peek() == '('))
                bracket.pop();
            else if (element == ')' && (bracket.peek() != '('))
                break;
        }
        if (bracket.isEmpty())
            result = "Ok";
        else
            result = "Error";
        return result;
    }
}
