package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.ResumeDto;


import java.util.List;

public interface CandidateService {
    DataResult<List<Candidate>> getAll();
    Result add(CandidateDto candidateDto);
    DataResult<ResumeDto> findById(int id);
}
