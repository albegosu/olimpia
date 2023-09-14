package olimpia.BackEnd.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user")
@NoArgsConstructor
@AllArgsConstructor
public class userModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Column(name="Nombre")
    private String userName;

    @Column(name="Password")
    private String userPassword;
}
