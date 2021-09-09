public class Main {
    public static void main(String[] args) {
        SkillRepository.save(new Skill((long) 1, "one"));
        SkillRepository.save(new Skill((long) 2, "two"));
        SkillRepository.save(new Skill((long) 3, "three"));
        System.out.println(SkillRepository.getAll());
        System.out.println(SkillRepository.getById((long) 2));
        System.out.println(SkillRepository.update(new Skill((long) 2, "five")));
        System.out.println(SkillRepository.getAll());
        SkillRepository.deleteById((long) 2);
        System.out.println(SkillRepository.getAll());
    }
}
