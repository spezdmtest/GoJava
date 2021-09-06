import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
     SkillRepository.save(new Skill((long) 1,"one"));
     SkillRepository.save(new Skill((long) 2,"two"));
     SkillRepository.save(new Skill((long) 3,"three"));
     System.out.println(SkillRepository.getAll());
//   System.out.println(SkillRepository.getById((long) 3));
    }
}
