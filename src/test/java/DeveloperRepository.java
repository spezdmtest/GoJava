import java.util.List;

public interface DeveloperRepository extends GenericRepository <Developer,Long> {
    List<Developer> getAll();
    Developer getById(Long id);
    Developer save(Developer t);
    Developer update (Developer t);
    void deleteById(Long id);
}
