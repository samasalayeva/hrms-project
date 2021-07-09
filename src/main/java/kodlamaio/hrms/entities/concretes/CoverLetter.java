package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cover_letters")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoverLetter {
    @Id
    @Column(name = "candidate_id")
    private int candidate_id;

    @Column(name = "content")
    private String content;

    @JsonIgnore
    @OneToOne(mappedBy = "coverLetter")
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;
}
