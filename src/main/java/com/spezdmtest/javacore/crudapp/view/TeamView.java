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
    private final Scanner scanner = new Scanner(System.in);

    public void showMainMenu() {
        System.out.println("Creating teams");
        createTeam();
        showAllTeams();
    }

    public void showAllTeams() {
        List<Team> allTeam = teamController.getAllTeam();
        System.out.println(allTeam);
    }

    public void createTeam() {
        List<Developer> developers = devController.getAllDev();
        System.out.print("Enter teams name: ");
        String name = scanner.nextLine();
        Team teams = teamController.createDev(name,developers);
    }
}
