package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.UniversityDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDepartmentDao extends JpaRepository<UniversityDepartment,Integer> {
}
