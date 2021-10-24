package com.spezdmtest.javacore.module1_5.AbstractFactory.banking;

import com.spezdmtest.javacore.module1_5.AbstractFactory.Developer;

public class JavaDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Java developer writes Java code...");
    }
}
