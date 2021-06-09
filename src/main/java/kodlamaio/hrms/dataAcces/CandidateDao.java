package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateDao extends JpaRepository<Candidate,Integer>{
   List<Candidate> findByIdentityNumber(String identity);
   List<Candidate> findByEmail(String email);
}
