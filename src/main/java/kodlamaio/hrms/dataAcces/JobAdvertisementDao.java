package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    @Query(" From JobAdvertisement where isActive=true")
    List<JobAdvertisement> getAllActiveJobAdvert();
    @Query("FROM JobAdvertisement WHERE isActive=true  ORDER BY applicationDeadline DESC")
    List<JobAdvertisement> findByActiveIsOrderApplicationDeadline();

    @Query(" FROM JobAdvertisement  WHERE isActive=true and employer.id=:employer_id ")
    List<JobAdvertisement> findByActiveIsAndEmployer_Id(int employer_id);

    JobAdvertisement findById(int id);
}
