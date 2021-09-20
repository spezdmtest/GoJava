package module1_3;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TeamRepositoryImpl implements TeamRepository {

    private final String JSON_PATH = "C:/Users/spezdm/IdeaProjects/GoJava/teams.json";
    private final Gson gson = new Gson();

    private List<Team> getAllTeamsInternal()  {
        List<Team> teams = null;
        try ( BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH))) {
            Type type = new TypeToken<ArrayList<Team>>() {}.getType();
            teams = gson.fromJson(reader,type);
        }catch (NullPointerException e) {
            System.out.println("Нет данных в файле");
        }catch (FileNotFoundException e) {
            System.out.println("Файл не возможно прочитать.");
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
        return teams;
    }

    private void writeListToFile(List<Team> teams) {
        try(FileWriter write = new FileWriter(JSON_PATH,false)) {
            gson.toJson(teams,write);
        }catch (IOException e) {
            System.out.println("Ошибка ввода-вывода.");
        }
    }

    public List<Team> getAll() {
        return getAllTeamsInternal();
    }

    public Team getById(Long id) {

        return getAllTeamsInternal().stream()
                .filter(team ->team.getId().equals(id))
                .findFirst().orElse(null);
    }

    public Team save(Team team) {
        List<Team> teams = getAllTeamsInternal();
        Long maxId = teams.stream()
                .map(x -> x.getId())
                .max(Long::compare)
                .orElse(null);
        team.setId(maxId+1);
        teams.add(team);
        writeListToFile(teams) ;

        return team;
    }
    public Team update(Team team) {
        List<Team> currentTeams = getAllTeamsInternal();
        currentTeams.forEach(s -> {
            if(s.getId().equals(team.getId())) {
                s.setName(team.getName());
            }
        });
        writeListToFile(currentTeams);

        return team;
    }

    public void deleteById(Long id) {
        List<Team> currentTeams = getAllTeamsInternal();
        currentTeams.removeIf(s -> s.getId().equals(id));
        writeListToFile(currentTeams);
    }
}



