package module1_3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Skills
        SkillRepositoryImpl repoSkills = new SkillRepositoryImpl();
        Skill skill2 = new Skill((long) 2,"two");
        Skill skill3 = new Skill((long) 3,"three");
        Skill skill4 = new Skill((long) 4,"four");
        repoSkills.save(skill2);
        repoSkills.save(skill3);
        repoSkills.save(skill4);
        System.out.println(repoSkills.getAll());
        repoSkills.update(new Skill((long) 3,"new three"));
        System.out.println(repoSkills.getAll());
        repoSkills.deleteById((long) 4);
        System.out.println(repoSkills.getAll());

        //Developers
        DeveloperRepositoryImpl repoDevelopers = new DeveloperRepositoryImpl();
        List<Skill> skills = repoSkills.getAll();
        repoDevelopers.save(new Developer((long) 2,"firstname2","lastname2", skills));
        System.out.println(repoDevelopers.getAll());
        repoDevelopers.update(new Developer((long) 2,"new firstname","new lastname", skills));
        System.out.println(repoDevelopers.getAll());
        repoDevelopers.deleteById((long) 1);

        //module1_3.Team
        TeamRepositoryImpl repoTeams = new TeamRepositoryImpl();
        List<Developer> developers = repoDevelopers.getAll();
        repoTeams.save(new Team((long) 2, "teamname2",developers));
        System.out.println(repoDevelopers.getAll());
        repoTeams.update(new Team((long) 1, "new teamname",developers));
        System.out.println(repoTeams.getAll());
        repoTeams.deleteById((long) 2);
    }
}
