package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.ItTechnology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItTechnologyDao extends JpaRepository<ItTechnology,Integer> {
}
