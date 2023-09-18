package olimpia.BackEnd.services;

import olimpia.BackEnd.models.contactModel;
import olimpia.BackEnd.repositories.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class contactService {

    private final contactRepository contactRepository;
    private final MailSender mailSender;

    @Autowired
    public contactService(contactRepository contactRepository, MailSender mailSender) {
        this.contactRepository = contactRepository;
        this.mailSender = mailSender;
    }

    public String enviarFormulario(contactModel contactModel) {
        contactRepository.save(contactModel);

        enviarCorreoElectronico(contactModel);

        return "Formulario enviado con éxito";
    }

    private void enviarCorreoElectronico(contactModel contactModel) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("albegosu@gmail.com");
        mailMessage.setSubject("Nuevo formulario de contacto");

        String mensaje = "Nuevo formulario de contacto:\n\n" +
                "Nombre: " + contactModel.getNombre() + "\n" +
                "Apellido: " + contactModel.getApellido() + "\n" +
                "Teléfono: " + contactModel.getTelefono() + "\n" +
                "Correo: " + contactModel.getCorreo() + "\n" +
                "Dolor: " + contactModel.getDolor();

        mailMessage.setText(mensaje);

        mailSender.send(mailMessage);
    }
}
