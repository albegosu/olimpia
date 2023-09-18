package olimpia.BackEnd.controllers;

import olimpia.BackEnd.models.contactModel;
import olimpia.BackEnd.services.contactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enviar-formulario")
public class contactController {

    private final contactService contactService;

    @Autowired
    public contactController(contactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping
    public String enviarFormulario(@RequestBody contactModel contactModel) {
        return contactService.enviarFormulario(contactModel);
    }
}
