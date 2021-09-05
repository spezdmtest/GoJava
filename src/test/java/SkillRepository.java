import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SkillRepository {

    static List<Skill> skills = new ArrayList<>();

    public static ArrayList<Skill> getAll() {
        final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/skills.json";
        Gson gson = new Gson();
        List<Skill> skills = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<ArrayList<Skill>>() {
            }.getType();
            skills = gson.fromJson(reader, type);
        }catch (NullPointerException e) {
            System.out.println("Нет данных в файле");
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не возможно прочитать.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода. ");
        }

        return (ArrayList<Skill>) skills;
    }

    public static Skill getById(Long id) {
        final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/skills.json";
        Gson gson = new Gson();
        List<Skill> skills = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<ArrayList<Skill>>(){}.getType();
            skills = gson.fromJson(reader,type);
        }catch (FileNotFoundException e) {
            System.out.println("Файл не возможно прочитать.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода. ");
        }

        return  skills.stream()
                      .filter(x -> x.getId().equals(id))
                      .map(x -> new Skill (x.getId(),x.getName()))
                      .findFirst().orElse(null);
    }

   public static Skill save(Skill skill) {
            skills.add(skill);
            final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/skills.json";
            Gson gson = new Gson();
            try (FileWriter writer = new FileWriter(JSON_PATH)) {
                gson.toJson(skills, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }

        return skill;
   }

//        try (FileWriter writer = new FileWriter("skills.json")) {
//            for (Skill data : list) {
//                Long id = data.getId();
//                String name = data.getName();
//                writer.write(id + " " + name + System.getProperty("line.separator"));
//            }

    void Print(ArrayList<Skill> skill) {
        skill.forEach(System.out::println);
    }

    ArrayList<Skill> update(ArrayList<Skill> skills) throws IOException {
        //Обновление данных в файле
        try (FileWriter writer = new FileWriter("skills.json")) {
            skills.removeAll(skills);
            skills.add(new Skill((long)3,"three"));
            skills.add(new Skill((long)4,"four"));
            for (Skill data : skills)  {
                Long id = data.getId();
                String name = data.getName();
                writer.write(id + " " + name + System.getProperty("line.separator"));
            }
        }catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return skills;
    }
    void deleteById(Long id) throws IOException { }

//    static ArrayList<Skill> parseJsonToSkills(String json){
//        Type targetClassType = new TypeToken<ArrayList<Skill>>() { }.getType();
//        Collection<Skill> targetCollection = new Gson().fromJson(json,targetClassType);
//        assertThat(targetCollection, instanceOf(ArrayList.class));
//        return (ArrayList) targetCollection;
//    }
}

