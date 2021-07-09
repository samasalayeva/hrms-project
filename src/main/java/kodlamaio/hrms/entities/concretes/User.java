package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.beans.ConstructorProperties;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public  class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Image> image;
}
