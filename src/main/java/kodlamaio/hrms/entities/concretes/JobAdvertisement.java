package kodlamaio.hrms.entities.concretes;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne
    private Employer employer;

    @ManyToOne
    private JobTitle jobTitle;

    @Column(name = "description")
    @NotBlank
    @NotNull
    private String description;


    @ManyToOne
     private City city;

    @Column(name = "position_number")
    @NotBlank
    @NotNull
    private int positionNumber;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    @Column(name = "application_deadline")
    @NotBlank
    @NotNull
    private LocalDate applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;


}
