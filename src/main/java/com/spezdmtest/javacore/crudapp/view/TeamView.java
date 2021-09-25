package com.spezdmtest.javacore.crudapp.view;

import com.spezdmtest.javacore.crudapp.controller.DeveloperController;
import com.spezdmtest.javacore.crudapp.controller.TeamController;
import com.spezdmtest.javacore.crudapp.model.Developer;
import com.spezdmtest.javacore.crudapp.model.Team;

import java.util.List;
import java.util.Scanner;

public class TeamView {
    private final TeamController teamController = new TeamController();
    private final DeveloperController devController = new DeveloperController();
    private final Scanner scanId= new Scanner(System.in);
    private final Scanner scanName = new Scanner(System.in);


    public void showMainMenu() {
        System.out.println("Create team");
        createTeam();
        showAllTeams();

        System.out.println("Update team");
        updateTeam();
        showAllTeams();

        System.out.println("Delete team");
        deleteByIdTeam();
        showAllTeams();
    }

    public void showAllTeams() {
        List<Team> allTeam = teamController.getAllTeam();
        System.out.println(allTeam);
    }

    public void createTeam() {
        List<Developer> developers = devController.getAllDev();
        System.out.print("Enter teams name: ");
        String name = scanName.nextLine();
        teamController.createDev(name,developers);
    }

    public void updateTeam() {
        System.out.print("Enter id team: ");
        Long id = scanId.nextLong();
        System.out.println("Enter new skill name: ");
        String name = scanName.nextLine();
        teamController.updateTeam(id,name);
    }

    public void deleteByIdTeam() {
        System.out.print("Enter id team for delete: ");
        Long id = scanId.nextLong();
        teamController.deleteByIdTeam(id);
    }
}
