package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.CoverLetterDao;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CoverLetterManager implements CoverLetterService {
    private CoverLetterDao coverLetterDao;

    @Autowired
    public CoverLetterManager(CoverLetterDao coverLetterDao) {
        this.coverLetterDao = coverLetterDao;
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<>(coverLetterDao.findAll());
    }

    @Override
    public Result add(CoverLetter coverLetter) {
        coverLetterDao.save(coverLetter);
        return new SuccessResult();
    }
}
