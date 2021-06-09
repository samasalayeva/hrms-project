package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAcces.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
import kodlamaio.hrms.entities.dtos.JobTitleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobTitleManager implements JobTitleService {
    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<>(jobTitleDao.findAll());
    }

    @Override
    public Result add(JobTitleDto jobTitleDto) {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setTitle(jobTitleDto.getTitle());
        jobTitle.setMinSalary(jobTitleDto.getMinSalary());
        jobTitle.setMaxSalary(jobTitleDto.getMaxSalary());
        jobTitleDao.save(jobTitle);
        return new SuccessDataResult<>(jobTitleDao.save(jobTitle),"Pozisyon eklendi");
    }
}
