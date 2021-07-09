package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Table(name = "verification_codes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public  class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "verified_data")
    private LocalDate verifiedData = LocalDate.now();
}
