package olimpia.BackEnd.controllers;

import olimpia.BackEnd.models.patientModel;
import olimpia.BackEnd.services.patientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "*")
public class patientController {

    @Autowired
    patientService myService;

    @GetMapping()
    public ArrayList<patientModel> getPatients(@RequestParam(required = false) String type){
        return myService.getPatients(type);
    }
    @GetMapping(path="/{id}") //Specific User
    public patientModel getById(@PathVariable int id){
        return myService.getById(id);
    }

    @PostMapping
    public patientModel setPatients(@RequestBody patientModel newPatient){
        return myService.setPatients(newPatient);
    }

    @DeleteMapping(path="/delete/{id}")
    public String deletePatient(@PathVariable int id){
        return myService.deletePatient(id);
    }

    @PutMapping(path="/update/{id}")
    public patientModel updateID(@PathVariable int id, @RequestBody patientModel newPatient){
        return myService.updateID(id, newPatient);
    }
}