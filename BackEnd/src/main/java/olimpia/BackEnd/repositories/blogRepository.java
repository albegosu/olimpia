package olimpia.BackEnd.repositories;

import olimpia.BackEnd.models.blogModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface blogRepository extends CrudRepository<blogModel, Integer> {
    List<blogModel> findByBlogTitle(String type);
}
