package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
@Entity
@Table(name ="resume_languages")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;

    @Min(1)
    @Max(5)
    @Column(name = "level")
    private int level;

    @ManyToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "id")
    private Candidate candidate;
}
