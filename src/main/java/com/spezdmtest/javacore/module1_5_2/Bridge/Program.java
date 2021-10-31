package com.spezdmtest.javacore.module1_5_2.Bridge;

public abstract class Program {
    protected Developer developer;

    protected Program (Developer developer) {
        this.developer = developer;
    }


    public abstract void developProgram();
}
