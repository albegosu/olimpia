package olimpia.BackEnd.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
@Entity
@Table(name="posts")
@NoArgsConstructor
@AllArgsConstructor
public class blogModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="Id")
    private int id;

    @Value("Tu título aquí")
    @Column(name="Title")
    private String blogTitle ;

    @Value("Tu mensaje aquí")
    @Column(name="Message")
    private String blogMessage;

    @Column(name="Image")
    private String imgUrl;
}