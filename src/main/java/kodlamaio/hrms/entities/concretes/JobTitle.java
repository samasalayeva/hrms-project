package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_titles")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name = "max_salary")
    private double maxSalary;

    @JsonIgnore
    @OneToMany(mappedBy = "jobTitle")
    private List<JobAdvertisement> jobAdvertisements;

    @JsonIgnore
    @OneToMany(mappedBy = "jobTitle")
    private List<WorkExperience> workExperiences;

}
