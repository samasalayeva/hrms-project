package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Candidate extends User {

    @Column(name = "first_name")
    private String firstName;


    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birth_day")
    private LocalDate birthOfDate;

    @Column(name = "identity_number")
    private String identityNumber;


    public Candidate(String email, String password, String firstName, String lastName, LocalDate birthOfDate, String identityNumber) {
        super(email, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthOfDate = birthOfDate;
        this.identityNumber = identityNumber;
    }

    @JsonIgnore
    @OneToOne
    @PrimaryKeyJoinColumn
    private CoverLetter coverLetter;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Education> educations;


    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<WorkExperience> workExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<ResumeLanguage> resumeLanguages;

    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<ResumeItTechnology> resumeItTechnologies;


    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Link> links;
}
