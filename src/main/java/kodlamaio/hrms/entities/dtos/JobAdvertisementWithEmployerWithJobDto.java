package kodlamaio.hrms.entities.dtos;


import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementWithEmployerWithJobDto {
    private String companyName;
    private String jobTitle;
    private int positionNumber;
    private LocalDate releaseDate;
    private LocalDate applicationDeadline;

}
