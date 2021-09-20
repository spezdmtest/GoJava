package com.spezdmtest.javacore.crudapp.controller;

import com.spezdmtest.javacore.crudapp.model.Skill;
import com.spezdmtest.javacore.crudapp.repository.SkillRepositoty;
import com.spezdmtest.javacore.crudapp.repository.json.JsonSkillRepositoryImpl;
import java.util.List;

public class SkillController {
    private final SkillRepositoty repoSkill = new JsonSkillRepositoryImpl();

    public List<Skill> getAllSkill() {
        return repoSkill.getAll();
    }

    public Skill createSkill(String name) {
        Skill s = new Skill();
        s.setName(name);
        return repoSkill.save(s);
    }
}
