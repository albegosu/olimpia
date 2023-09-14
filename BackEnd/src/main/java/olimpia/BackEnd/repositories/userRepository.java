package olimpia.BackEnd.repositories;

import olimpia.BackEnd.models.userModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface userRepository extends CrudRepository<userModel, Integer> {
    List<userModel> findByUserName(String userName);
}
