import java.util.Optional;

public class Skill {

    private Long id;
    private String name;


    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    public Skill(Long maxId) {
//        this.id = maxId;
//    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long setId(long id) {
        this.id = id;
        return id;
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
