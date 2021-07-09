package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {
    @Query("From WorkExperience order by endDate desc")
    List<WorkExperience> findByEndDateSorted();
}
