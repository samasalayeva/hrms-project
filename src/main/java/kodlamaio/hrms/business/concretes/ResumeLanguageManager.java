package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.ResumeLanguageDao;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeLanguageManager implements ResumeLanguageService {
    private ResumeLanguageDao resumeLanguageDao;

    @Autowired
    public ResumeLanguageManager(ResumeLanguageDao resumeLanguageDao) {
        this.resumeLanguageDao = resumeLanguageDao;
    }


    @Override
    public DataResult<List<ResumeLanguage>> getAll() {
        return new SuccessDataResult<>(resumeLanguageDao.findAll());
    }

    @Override
    public Result add(ResumeLanguage resumeLanguage) {
        resumeLanguageDao.save(resumeLanguage);
        return new SuccessResult();
    }
}
