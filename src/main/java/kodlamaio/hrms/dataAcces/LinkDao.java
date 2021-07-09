package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link,Integer> {
}
