package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.ResumeLanguage;

import java.util.List;

public interface ResumeLanguageService {
    DataResult<List<ResumeLanguage>> getAll();
    Result add(ResumeLanguage resumeLanguage);
}
