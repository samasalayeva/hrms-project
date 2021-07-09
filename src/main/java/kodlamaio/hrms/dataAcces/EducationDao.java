package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationDao extends JpaRepository<Education,Integer> {
    @Query("From Education order by endDate desc")
    List<Education> findByEndDateSorted();
}
