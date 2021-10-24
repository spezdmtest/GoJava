package com.spezdmtest.javacore.module1_5.AbstractFactory.banking;

import com.spezdmtest.javacore.module1_5.AbstractFactory.Developer;
import com.spezdmtest.javacore.module1_5.AbstractFactory.ProjectManager;
import com.spezdmtest.javacore.module1_5.AbstractFactory.ProjectTeamFactory;
import com.spezdmtest.javacore.module1_5.AbstractFactory.Tester;

public class BankingTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new QATester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new BankingPM();
    }
}
