import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws IOException {
                String json = "[{\"id\":1,\"name\":\"one\"},{\"id\":2,\"name\":\"two\"}]";
                ArrayList<Skill> skills = SkillRepository.givenJsonOfSkill(json);
                SkillRepository skillRepository = new SkillRepository();

                System.out.println("Исходные данные из Json файла: ");
                skillRepository.Print(skills);
                //запись исходных данных в файл
                skillRepository.save(skills);
                System.out.println();
                System.out.println("Вывод данных по id ");
                System.out.println("введите номер id: ");
                Scanner in = new Scanner(System.in);
                long num = in.nextLong();
                System.out.println("Результат: ");
                System.out.println(skillRepository.getById(num));
                System.out.println("Вывод всех данных: ");
                System.out.println(skillRepository.getAll());
                System.out.println("Обновление данных ");
                System.out.println(skillRepository.update(skills));
                System.out.println("Удаления данных ");
                System.out.println("Введите номер id: ");
        }
}
