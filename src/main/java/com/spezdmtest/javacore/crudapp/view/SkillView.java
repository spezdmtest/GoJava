package com.spezdmtest.javacore.crudapp.view;

import com.spezdmtest.javacore.crudapp.controller.SkillController;
import com.spezdmtest.javacore.crudapp.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private final SkillController skillController = new SkillController();
    private final Scanner scanId = new Scanner(System.in);
    private final Scanner scanName = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("Create skill");
        createSkill();
        showAllSkills();

        System.out.println("Update skill");
        updateSkill();
        showAllSkills();

        System.out.println("Delete skill");
        deleteByIdSkill();
        showAllSkills();
    }

    public void showAllSkills() {
        List<Skill> allSkills = skillController.getAllSkill();
        System.out.println(allSkills);
    }

    public void createSkill() {
        System.out.println("Enter skill name: ");
        String name = scanName.nextLine();
        skillController.createSkill(name);
    }

    public void updateSkill() {
        System.out.print("Enter id skill: ");
        Long id = scanId.nextLong();
        System.out.print("Enter new skill name: ");
        String name = scanName.nextLine();
        skillController.updateSkill(id,name);
    }

    public void deleteByIdSkill() {
        System.out.print("Enter id skill for delete: ");
        Long id = scanId.nextLong();
        skillController.deleteByIdSkill(id);
    }
}
