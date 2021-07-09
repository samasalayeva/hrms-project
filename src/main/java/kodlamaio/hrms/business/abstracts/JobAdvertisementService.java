package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIs();
    DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIsOrderApplicationDeadline();
    DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIsAndEmployer_Id(int employer_id);
    Result isActiveOrIsPassive(int id, boolean isActive);
}
