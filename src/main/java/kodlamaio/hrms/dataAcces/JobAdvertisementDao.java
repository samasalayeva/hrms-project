package kodlamaio.hrms.dataAcces;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto(e.companyName, jt.title, j.positionNumber,j.releaseDate, j.applicationDeadline) " +
            " From JobAdvertisement j inner join j.employer e  inner join j.jobTitle jt where j.isActive=true")
    List<JobAdvertisementWithEmployerWithJobDto> getAllActiveJobAdvert();
   
   
   
    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto(e.companyName, jt.title, j.positionNumber,j.releaseDate, j.applicationDeadline)" +
            "From JobAdvertisement j inner join j.employer e  inner join j.jobTitle jt where j.isActive=true ORDER BY j.applicationDeadline DESC")
    List<JobAdvertisementWithEmployerWithJobDto> findByActiveIsOrderApplicationDeadline();

    @Query("select new kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto(e.companyName, jt.title, j.positionNumber,j.releaseDate, j.applicationDeadline) " +
            " From JobAdvertisement j inner join j.employer e  inner join j.jobTitle jt where j.isActive=true and j.employer.id=:employer_id ")
    List<JobAdvertisementWithEmployerWithJobDto> findByActiveIsAndEmployer_Id(int employer_id);

    JobAdvertisement findById(int id);
}
