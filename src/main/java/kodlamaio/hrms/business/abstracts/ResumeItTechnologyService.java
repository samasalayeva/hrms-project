package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ResumeItTechnology;

import java.util.List;

public interface ResumeItTechnologyService {
    DataResult<List<ResumeItTechnology>> getAll();
    Result add(ResumeItTechnology resumeItTechnology);
}
