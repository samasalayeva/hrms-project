package kodlamaio.hrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "work_experiences")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "business_name")
    private String businessName;

    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;


    @ManyToOne
    @JoinColumn(name = "job_title_id", referencedColumnName = "id")
    private JobTitle jobTitle;



    public String getEndDate(){
        if(endDate == null){
            return "Devam ediyor";
        }
        return endDate.toString();
    }
}


