package com.spezdmtest.javacore.module1_5_1.AbstractFactory.banking;
import com.spezdmtest.javacore.module1_5_1.AbstractFactory.ProjectManager;

public class BankingPM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Banking PM manages banking project...");
    }
}
