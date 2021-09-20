package com.spezdmtest.javacore.crudapp.view;

import com.spezdmtest.javacore.crudapp.controller.SkillController;
import com.spezdmtest.javacore.crudapp.model.Skill;

import java.util.List;
import java.util.Scanner;

public class SkillView {
    private final SkillController skillController = new SkillController();
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("Creating skills");
        createSkill();
        showAllSkills();
    }

    public void showAllSkills() {
        List<Skill> allSkills = skillController.getAllSkill();
        System.out.println(allSkills);
    }

    public void createSkill() {
        System.out.println("Enter skill name: ");
        String name = scanner.nextLine();
        Skill skill = skillController.createSkill(name);
    }
}
