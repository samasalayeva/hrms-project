package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "resumes_it_technologies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeItTechnology {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "it_technology_id", referencedColumnName = "id")
    private ItTechnology itTechnology;


    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;
}
