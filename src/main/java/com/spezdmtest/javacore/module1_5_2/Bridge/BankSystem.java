package com.spezdmtest.javacore.module1_5_2.Bridge;

public class BankSystem extends Program {

    public BankSystem(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Bank System development in progress....");
        developer.writeCode();
    }
}
