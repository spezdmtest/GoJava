package com.spezdmtest.javacore.crudapp.controller;

import com.spezdmtest.javacore.crudapp.model.Developer;
import com.spezdmtest.javacore.crudapp.model.Team;
import com.spezdmtest.javacore.crudapp.repository.TeamRepository;
import com.spezdmtest.javacore.crudapp.repository.json.JsonTeamRepositoryImpl;

import java.util.List;

public class TeamController {
    private final TeamRepository repoTeam = new JsonTeamRepositoryImpl();

    public List<Team> getAllTeam() {
        return repoTeam.getAll();
    }

    public Team createDev(String name, List<Developer> developers) {
        Team t = new Team();
        t.setName(name);
        t.setDevelopers(developers);
        return repoTeam.save(t);
    }

    public Team updateTeam(Long id, String name) {
        Team t = new Team();
        t.setId(id);
        t.setName(name);
        return repoTeam.update(t);
    }
}
