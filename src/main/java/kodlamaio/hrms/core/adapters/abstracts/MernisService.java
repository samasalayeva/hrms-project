package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.CandidateDto;

public interface MernisService {
    Result isIdentity(CandidateDto candidateDto);
}
