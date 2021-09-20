package com.spezdmtest.javacore.crudapp.AppRunner;

import com.spezdmtest.javacore.crudapp.view.DevView;
import com.spezdmtest.javacore.crudapp.view.SkillView;

public class Application {
    public static void main(String[] args) {
        SkillView viewSkill = new SkillView();
        viewSkill.showMainMenu();
        System.out.println();
        DevView viewDev = new DevView();
        viewDev.showMainMenu();
    }
}
