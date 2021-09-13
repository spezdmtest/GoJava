import java.util.List;

public interface SkillRepositoty extends GenericRepository<Skill,Long> {
    List<Skill> getAll();
    Skill getById(Long id);
    Skill save(Skill t);
    Skill update (Skill t);
    void deleteById(Long id);
}
