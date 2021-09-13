import java.util.List;

public interface DeveloperRepository extends GenericRepository <Developer,Long> {
    List<Developer> getAll();
    Developer getById(Long id);
    Developer save(Developer d);
    Developer update (Developer d);
    void deleteById(Long id);
}
