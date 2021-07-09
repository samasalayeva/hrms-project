package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "employers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Employer extends User {

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "web_address")
    private String webSite;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;


    public Employer(String email, String password, String companyName, String webSite, String phoneNumber) {
        super(email, password);
        this.companyName = companyName;
        this.webSite = webSite;
        this.phoneNumber = phoneNumber;
    }


}
