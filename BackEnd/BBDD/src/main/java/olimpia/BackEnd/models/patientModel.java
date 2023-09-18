package olimpia.BackEnd.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="patients")
@NoArgsConstructor
@AllArgsConstructor
public class patientModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Nombre")
    private String patientName;

    @Column(name="Apellido")
    private String patientLastName;

    @Column(name="Edad")
    private int age;

    @Column(name="FechaConsulta")
    @Temporal(TemporalType.DATE)
    private Date consultationDate;

    @Enumerated(EnumType.STRING)
    @Column(name="ZonaDolor")
    private PainArea painType;

    @Column(name="Teléfono")
    private String tel;

    @Column(name="Descripcion")
    private String description;

    public enum PainArea {
        CUELLO,
        ESPALDA,
        HOMBRO,
        TOBILLO,
        CADERA
    }
}