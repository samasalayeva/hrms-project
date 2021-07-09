package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeItTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.ResumeItTechnologyDao;
import kodlamaio.hrms.entities.concretes.ResumeItTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeItTechnologyManager implements ResumeItTechnologyService {
    private ResumeItTechnologyDao resumeItTechnologyDao;

    @Autowired
    public ResumeItTechnologyManager(ResumeItTechnologyDao resumeItTechnologyDao) {
        this.resumeItTechnologyDao = resumeItTechnologyDao;
    }

    @Override
    public DataResult<List<ResumeItTechnology>> getAll() {
        return new SuccessDataResult<>(resumeItTechnologyDao.findAll());
    }

    @Override
    public Result add(ResumeItTechnology resumeItTechnology) {
        resumeItTechnologyDao.save(resumeItTechnology);
        return new SuccessResult("ekleme islemi tamamlandi");
    }
}
