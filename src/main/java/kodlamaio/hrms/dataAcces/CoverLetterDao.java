package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter,Integer> {
}
