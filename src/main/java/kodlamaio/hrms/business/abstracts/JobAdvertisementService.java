package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisement jobAdvertisement);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> findByActiveIs();
    DataResult<List<JobAdvertisement>> findByActiveIsOrderApplicationDeadline();
    DataResult<List<JobAdvertisement>> findByActiveIsAndEmployer_Id(int employer_id);
    Result isActiveOrIsPassive(int id, boolean isActive);
}
