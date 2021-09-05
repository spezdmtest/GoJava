import java.util.function.ToLongFunction;

public class Skill {

    private Long id;
    private String name;


    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long setId(long id) {
        this.id = id;
        return null;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name: " + name;
    }


}
