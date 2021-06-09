package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
    private String description;


    @ManyToOne
     private City city;

    @Column(name = "position_number")
    private int positionNumber;

    @Column(name = "release_date")
    private LocalDate releaseDate = LocalDate.now();

    @Column(name = "application_deadline")
    private LocalDate applicationDeadline;

    @Column(name = "is_active")
    private boolean isActive;




    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = LocalDate.now();
    }

}
