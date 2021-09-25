package com.spezdmtest.javacore.crudapp.AppRunner;

import com.spezdmtest.javacore.crudapp.view.DeveloperView;
import com.spezdmtest.javacore.crudapp.view.SkillView;
import com.spezdmtest.javacore.crudapp.view.TeamView;

public class Application {
    public static void main(String[] args) {
        SkillView skillView = new SkillView();
        skillView.showMainMenu();
        System.out.println();

        DeveloperView developerView = new DeveloperView();
        developerView.showMainMenu();
        System.out.println();

        TeamView teamView = new TeamView();
        teamView.showMainMenu();
        System.out.println();
    }
}
