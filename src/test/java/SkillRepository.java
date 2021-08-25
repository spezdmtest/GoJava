import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkillRepository  {
    public int getById(Long id) {
        return 0;
    }

    public void save(ArrayList<Skill> list) {

    }

    public List<Skill> getAll(ArrayList<Skill> list) {
        list.stream().collect(Collectors.toList());
        return list;
    };

    public void Print(List<Skill> list) {
        list.forEach(System.out::println);
    }

    public Skill update(Skill skill) {
        return null;
    }

    public void deleteById(Long id) {}

    public static ArrayList givenJsonOfSkill(String json){
      Type targetClassType = new TypeToken<ArrayList<Skill>>() { }.getType();
      Collection<Skill> targetCollection = new Gson().fromJson(json,targetClassType);
      assertThat(targetCollection, instanceOf(ArrayList.class));
      return (ArrayList) targetCollection;
    }
}
