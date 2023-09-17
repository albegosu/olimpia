package olimpia.BackEnd.repositories;

import olimpia.BackEnd.models.contactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface contactRepository extends JpaRepository<contactModel, Long> {
}
