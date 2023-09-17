package olimpia.BackEnd.repositories;

import olimpia.BackEnd.models.patientModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface patientRepository extends CrudRepository<patientModel, Integer> {
    List<patientModel> findByPatientName(String type);
}
