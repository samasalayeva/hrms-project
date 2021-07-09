package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "links")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "url_adrress")
    private String urlAddress;

    @ManyToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private Candidate candidate;
}
