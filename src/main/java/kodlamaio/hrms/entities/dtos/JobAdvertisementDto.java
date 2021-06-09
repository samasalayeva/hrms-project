package kodlamaio.hrms.entities.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementDto {
    private int employer_id;
    private int job_title_id;
    private String description;
    private int city_id;
    private int positionNumber;
    private LocalDate applicationDeadline;

}
