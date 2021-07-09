package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "educations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    private University university;


    @ManyToOne
    @JoinColumn(name = "university_department_id", referencedColumnName = "id")
    private UniversityDepartment universityDepartment;

    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;


    @Column(name = "begin_date")
    private LocalDate beginDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public String getEndDate(){
        if(endDate == null){
            return "Devam ediyor";
        }
        return endDate.toString();
    }



}
