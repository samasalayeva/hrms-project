package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;


    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }


    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<>(jobAdvertisementDao.findAll());
    }

   @Override
    public DataResult<List<JobAdvertisement>> findByActiveIs() {
        return new SuccessDataResult<>(jobAdvertisementDao.getAllActiveJobAdvert());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveIsOrderApplicationDeadline() {
        return new SuccessDataResult<>(jobAdvertisementDao.findByActiveIsOrderApplicationDeadline());
    }

    @Override
    public DataResult<List<JobAdvertisement>> findByActiveIsAndEmployer_Id(int employer_id) {
        return new SuccessDataResult<>(jobAdvertisementDao.findByActiveIsAndEmployer_Id(employer_id));
    }

    @Override
    public Result isActiveOrIsPassive(int id, boolean isActive) {
       JobAdvertisement jobAdvertisement = jobAdvertisementDao.findById(id);
        if(!jobAdvertisement.isActive() && isActive) {

            jobAdvertisement.setActive(isActive);
            this.jobAdvertisementDao.save(jobAdvertisement);
            return new SuccessResult("İlan aktif duruma getirildi");

        }else if(jobAdvertisement.isActive() && !isActive) {

            jobAdvertisement.setActive(isActive);
            this.jobAdvertisementDao.save(jobAdvertisement);

            return new SuccessResult("İlan pasif duruma getirildi");
        }
        else if(jobAdvertisement.isActive() && isActive) {
            return new ErrorResult("İlan zaten aktif");
        }
        else if(!jobAdvertisement.isActive() && !isActive) {
            return new ErrorResult("İlan zaten pasif");
        }

            return new ErrorResult("Null değer girdiniz");

    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement){
        jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult("is ilani kayd edildi");
    }


}
