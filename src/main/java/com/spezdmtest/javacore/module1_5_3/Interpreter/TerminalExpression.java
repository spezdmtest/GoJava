package com.spezdmtest.javacore.module1_5_3.Interpreter;

public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
       if (context.contains(data)) {
           return true;
       }
       return false;
    }
}
