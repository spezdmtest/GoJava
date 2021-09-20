package module1_3;

import java.util.List;

public interface TeamRepository extends GenericRepository<Team,Long> {
     List<Team> getAll();
     Team getById(Long id);
     Team save(Team t);
     Team update (Team t);
     void deleteById(Long id);
}
