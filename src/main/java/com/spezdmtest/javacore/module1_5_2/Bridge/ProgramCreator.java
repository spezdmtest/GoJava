package com.spezdmtest.javacore.module1_5_2.Bridge;

public class ProgramCreator {
    public static void main(String[] args) {
        Program[] programs = {
                new BankSystem(new CppDeveloper()),
                new StockExchange(new JavaDeveloper())
        };

        for(Program program: programs) {
            program.developProgram();
        }
    }
}
