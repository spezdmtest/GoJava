import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
     Skill one = SkillRepository.save(new Skill((long) 1, "one"));
     Skill two = SkillRepository.save(new Skill((long) 2,"two"));
     Skill three = SkillRepository.save(new Skill((long) 3,"three"));
//     System.out.println(SkillRepository.getAll());
     SkillRepository.update(three);

    }
}
