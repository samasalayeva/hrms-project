package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAcces.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {
    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<>(educationDao.findAll());
    }

    @Override
    public Result add(Education education) {
        return new SuccessDataResult<>(educationDao.save(education));
    }

    @Override
    public DataResult<List<Education>> findByEndDateSorted() {
        return new SuccessDataResult<>(educationDao.findByEndDateSorted());
    }
}
