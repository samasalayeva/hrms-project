package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.WorkExperienceDao;
import kodlamaio.hrms.entities.concretes.WorkExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkExperienceManager implements WorkExperienceService {
    private WorkExperienceDao workExperienceDao;

    @Autowired
    public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
        this.workExperienceDao = workExperienceDao;
    }

    @Override
    public DataResult<List<WorkExperience>> getAll() {
        return new SuccessDataResult<>(workExperienceDao.findAll(),"data listelendi");
    }

    @Override
    public Result add(WorkExperience workExperience) {
        workExperienceDao.save(workExperience);
        return new SuccessResult("cv ekleme islem tamamlandi");
    }

    @Override
    public DataResult<List<WorkExperience>> findByEndDate() {
        return new SuccessDataResult<>(workExperienceDao.findByEndDateSorted());
    }
}
