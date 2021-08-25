import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String json = "[{\"id\":1,\"name\":\"one\"},{\"id\":2,\"name\":\"two\"}]";
        ArrayList arrayList = SkillRepository.givenJsonOfSkill(json);
        SkillRepository skillPrint = new SkillRepository();
        skillPrint.Print(arrayList);
    }
}
