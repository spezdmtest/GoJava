package com.spezdmtest.javacore.crudapp.view;

import com.spezdmtest.javacore.crudapp.controller.DeveloperController;
import com.spezdmtest.javacore.crudapp.controller.SkillController;
import com.spezdmtest.javacore.crudapp.model.Developer;
import com.spezdmtest.javacore.crudapp.model.Skill;

import java.util.List;
import java.util.Scanner;

public class DevView {
    private final DeveloperController devController = new DeveloperController();
    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu () {
        System.out.println("Creating developers");
        createDev();
        showAllDevelopers();

    }

    public void showAllDevelopers() {
        List<Developer> allDev = devController.getAllDev();
        System.out.println(allDev);
    }

    public void createDev() {
        List<Skill> skills = skillController.getAllSkill();
        System.out.print("Enter developers FirstName: ");
        String FirstName = scanner.nextLine();
        System.out.print("Enter developers LastName: ");
        String LastName = scanner.nextLine();
        Developer dev = devController.createDev(FirstName,LastName,skills);
    }
}
