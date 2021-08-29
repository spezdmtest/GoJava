import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkillRepository  {

    public ArrayList<String> getById(Long id) throws IOException {
        String path = "C:/Users/spezdm/IdeaProjects/GoJava/skill.txt";
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        return (ArrayList<String>) list.stream().filter(x -> Long.parseLong(x.split("\\s")[0]) == id)
                .collect(Collectors.toList());
    }

    public void save(ArrayList<Skill> list) {
        try (FileWriter writer = new FileWriter("skill.txt")) {
            for (Skill data : list) {
                Long id = data.getId();
                String name = data.getName();
                writer.write(id + " " + name + System.getProperty("line.separator"));
            }
        }catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
    }
    public ArrayList<String> getAll() {
        String path = "C:/Users/spezdm/IdeaProjects/GoJava/skill.txt";
        List<String> list = null;
        try {
            list = Files.readAllLines(Paths.get(path));
        }catch(IOException e) {
            System.out.println("Ошибка ввода-вывода");
        }
        return (ArrayList<String>) list.stream().collect(Collectors.toList());
    }

    public void Print(ArrayList<Skill> skills) {
        skills.forEach(System.out::println);
    }

    public ArrayList<Skill> update(ArrayList<Skill> skills) throws IOException {
        //Обновление данных в файле
        try (FileWriter writer = new FileWriter("skill.txt")) {
            skills.removeAll(skills);
            skills.add(new Skill((long)3,"three"));
            skills.add(new Skill((long)4,"four"));
            for (Skill data : skills) {
                Long id = data.getId();
                String name = data.getName();
                writer.write(id + " " + name + System.getProperty("line.separator"));
            }
        }catch (IOException e) {
            System.out.println("Произошла ошибка ввода-вывода");
        }
        return skills;
    }
    public void deleteById(Long id) throws IOException {
//            ArrayList<String> list = getAll();
//            list.remove(id);
//            try(FileWriter writer = new FileWriter("skill.txt")) {
//                for(String data : list){
//                    writer.write(data);
//                }
            }


    public static ArrayList givenJsonOfSkill(String json){
        Type targetClassType = new TypeToken<ArrayList<Skill>>() { }.getType();
        Collection<Skill> targetCollection = new Gson().fromJson(json,targetClassType);
        assertThat(targetCollection, instanceOf(ArrayList.class));
        return (ArrayList) targetCollection;
    }
}

