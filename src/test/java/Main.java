import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Skills
        SkillRepositoryImpl repoSkills = new SkillRepositoryImpl();
        Skill skill2 = new Skill((long) 2,"two");
        Skill skill3 = new Skill((long) 3,"three");
        repoSkills.save(skill2);
        repoSkills.save(skill3);
        System.out.println(repoSkills.getAll());
//        repoSkills.update(new Skill((long) 3,"new three"));
//        System.out.println(repoSkills.getAll());
//        repoSkills.deleteById((long) 3);
//        System.out.println(repoSkills.getAll());

        //Developers
        DeveloperRepositoryImpl repoDevelopers = new DeveloperRepositoryImpl();
        List<Skill> skills = repoSkills.getAll();
        repoDevelopers.save( new Developer((long) 2,"firstname2","lastname2", skills));
        System.out.println(repoDevelopers.getAll());
        repoDevelopers.update(new Developer((long) 2,"new firstname","new lastname", skills));
        System.out.println(repoDevelopers.getAll());
        repoDevelopers.deleteById((long) 1);

        //Team



    }
}
