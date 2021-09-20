package module1_3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SkillRepositoryImpl implements SkillRepositoty {


    private final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/skills.json";
    private final Gson gson = new Gson();

    private List<Skill> getAllSkillsInternal()  {
        List<Skill> skills = null;
        try ( BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<ArrayList<Skill>>() {}.getType();
            skills = gson.fromJson(reader,type);
        }catch (NullPointerException e) {
            System.out.println("Нет данных в файле");
        }catch (FileNotFoundException e) {
            System.out.println("Файл не возможно прочитать.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
        return skills;
    }

    private void writeListToFile(List<Skill> skills) {
        try(FileWriter write = new FileWriter(JSON_PATH,false)) {
            gson.toJson(skills,write);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
    }

    public List<Skill> getAll() {
        return getAllSkillsInternal();
    }

    public Skill getById(Long id) {

        return  getAllSkillsInternal().stream()
                .filter(skill ->skill.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Skill save(Skill skill) {
        List<Skill> skills = getAllSkillsInternal();
        Long maxId = skills.stream()
                .map(x -> x.getId())
                .max(Long::compare)
                .orElse(null);
        skill.setId(maxId+1);
        skills.add(skill);
        writeListToFile(skills);
        return skill;
    }
    public Skill update(Skill skill) {
        List<Skill> currentSkills = getAllSkillsInternal();
        currentSkills.forEach(s -> {
            if(s.getId().equals(skill.getId())) {
                s.setName(skill.getName());
            }
        });
        writeListToFile(currentSkills);
        return skill;
    }

    public void deleteById(Long id) {
        List<Skill> currentSkills = getAllSkillsInternal();
        currentSkills.removeIf(s -> s.getId().equals(id));
        writeListToFile(currentSkills);
    }
}



