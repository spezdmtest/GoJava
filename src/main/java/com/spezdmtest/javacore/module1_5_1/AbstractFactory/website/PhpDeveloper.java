package com.spezdmtest.javacore.module1_5_1.AbstractFactory.website;

import com.spezdmtest.javacore.module1_5_1.AbstractFactory.Developer;

public class PhpDeveloper implements Developer {
    @Override
    public void writeCode() {
        System.out.println("Php developer writes php code....");
    }
}
