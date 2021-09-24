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
    private final Scanner scanId = new Scanner(System.in);
    private final Scanner scanName = new Scanner(System.in);


    public void showMainMenu () {
        System.out.println("Creating developers");
        createDev();
        showAllDevelopers();

        System.out.println("Updating developers");
        updateDev();
        showAllDevelopers();
    }

    public void showAllDevelopers() {
        List<Developer> allDev = devController.getAllDev();
        System.out.println(allDev);
    }

    public void createDev() {
        List<Skill> skills = skillController.getAllSkill();
        System.out.print("Enter developers FirstName: ");
        String FirstName = scanName.nextLine();
        System.out.print("Enter developers LastName: ");
        String LastName = scanName.nextLine();
        Developer dev = devController.createDev(FirstName,LastName,skills);
    }

    public void updateDev() {
        System.out.print("Enter id developer name: ");
        Long id = scanId.nextLong();
        System.out.print("Enter new FirstName developers: ");
        String FirstName = scanName.nextLine();
        System.out.println("Enter new LastName developers: ");
        String LastName = scanName.nextLine();
        Developer developer = devController.updateDev(id,FirstName,LastName);
    }
}
