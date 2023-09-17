package olimpia.BackEnd.services;

import olimpia.BackEnd.models.patientModel;
import olimpia.BackEnd.repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class patientService {

    @Autowired
    patientRepository myRepo;
    public ArrayList<patientModel> getPatients(String type) {
        if (type == null || type.isEmpty()) {
            return new ArrayList<patientModel>((Collection) myRepo.findAll());
        } else {
            return new ArrayList<>(myRepo.findByPatientName(type));
        }
    }
    public patientModel getById(int id){
        return myRepo.findById(id).orElse(null);
    }

    public String deletePatient(int id) {
        try{
            myRepo.deleteById(id);
            return "Record "+id+" was successfully deleted.";
        }
        catch(Exception e){
            return "Unable to delete record: \n"+e.getMessage();
        }
    }

    public patientModel setPatients(patientModel newPatient) {
        try{
            return myRepo.save(newPatient);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public patientModel updateID(int id, patientModel newPatient) {
        try {
            Optional<patientModel> optionalPatient = myRepo.findById(id);

            if (optionalPatient.isPresent()) {
                patientModel toUpdatePatient = optionalPatient.get();

                // Realizar operaciones con toUpdatePatient
                toUpdatePatient.setPatientName(newPatient.getPatientName());
                toUpdatePatient.setPatientLastName(newPatient.getPatientLastName());
                toUpdatePatient.setPainType(newPatient.getPainType());
                toUpdatePatient.setDescription(newPatient.getDescription());
                toUpdatePatient.setTel(newPatient.getTel());

                return myRepo.save(toUpdatePatient); // Guardar los cambios en la base de datos y devolver el paciente actualizado
            } else {
                // Manejar el caso en el que el paciente no se encuentre
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
