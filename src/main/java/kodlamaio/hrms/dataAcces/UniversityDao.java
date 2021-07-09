package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDao extends JpaRepository<University,Integer> {
}
