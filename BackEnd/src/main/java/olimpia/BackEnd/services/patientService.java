package olimpia.BackEnd.services;

import olimpia.BackEnd.models.patientModel;
import olimpia.BackEnd.repositories.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

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


    public patientModel getOnePatient(int id){
        try{
            return myRepo.findById(id).orElse(null);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
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

    public patientModel updatePatient(int id, patientModel newPatient) {
        try{
            patientModel toUpdatePatient= myRepo.findById(id).get();
            toUpdatePatient.setPatientName(newPatient.getPatientName());
            toUpdatePatient.setPatientLastName(newPatient.getPatientLastName());
            toUpdatePatient.setAge(newPatient.getAge());
            toUpdatePatient.setConsultationDate(newPatient.getConsultationDate());
            toUpdatePatient.setPainType(newPatient.getPainType());
            toUpdatePatient.setDescription(newPatient.getDescription());

            return toUpdatePatient;

        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
