package com.spezdmtest.javacore.crudapp.repository;

import com.spezdmtest.javacore.crudapp.model.Skill;

import java.util.List;

public interface SkillRepositoty extends GenericRepository<Skill,Long> {
    List<Skill> getAll();
    Skill getById(Long id);
    Skill save(Skill s);
    Skill update(Skill s);
    void deleteById(Long id);
}
