package module1_3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DeveloperRepositoryImpl implements DeveloperRepository {


    private final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/developers.json";
    private final Gson gson = new Gson();

    private List<Developer> getAllDevelopersInternal()  {
        List<Developer> developers = null;
        try ( BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<ArrayList<Developer>>() {}.getType();
            developers = gson.fromJson(reader,type);
        }catch (NullPointerException e) {
            System.out.println("Нет данных в файле");
        }catch (FileNotFoundException e) {
            System.out.println("Файл не возможно прочитать.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
        return developers;
    }

    private void writeListToFile(List<Developer> developers) {
        try(FileWriter write = new FileWriter(JSON_PATH,false)) {
            gson.toJson(developers,write);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
    }

    public List<Developer> getAll() {
        return getAllDevelopersInternal();
    }

    public Developer getById(Long id) {
        return getAllDevelopersInternal().stream()
                .filter(developer ->developer.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Developer save(Developer developer) {
        List<Developer> developers = getAllDevelopersInternal();
        Long maxId = developers.stream()
                .map(x -> x.getId())
                .max(Long::compare)
                .orElse(null);
        developer.setId(maxId+1);
        developers.add(developer);
        writeListToFile(developers) ;

        return developer;
    }
    public Developer update(Developer developer) {
        List<Developer> currentDevelopers = getAllDevelopersInternal();
        currentDevelopers.forEach(s -> {
            if(s.getId().equals(developer.getId())) {
                s.setFirstName(developer.getFirstName());
                s.setLastName(developer.getLastName());
            }
        });
        writeListToFile(currentDevelopers);
        return developer;
    }

    public void deleteById(Long id) {
        List<Developer> currentDevelopers = getAllDevelopersInternal();
        currentDevelopers.removeIf(s -> s.getId().equals(id));
        writeListToFile(currentDevelopers);
    }
}



