package com.spezdmtest.javacore.module1_5_2.Bridge;

public class StockExchange extends Program {
    public StockExchange(Developer developer) {
        super(developer);
    }

    @Override
    public void developProgram() {
        System.out.println("Stock Exchange development in progress....");
        developer.writeCode();
    }
}
