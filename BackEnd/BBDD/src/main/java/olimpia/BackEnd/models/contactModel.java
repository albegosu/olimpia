package olimpia.BackEnd.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "formulario_contacto")
@NoArgsConstructor
@AllArgsConstructor
public class contactModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long id;

    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String dolor;
}

