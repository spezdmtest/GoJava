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
        return id;
    }

    public String setName(String name)
    {
        this.name = name;
        return name;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name: " + name;
    }


}
