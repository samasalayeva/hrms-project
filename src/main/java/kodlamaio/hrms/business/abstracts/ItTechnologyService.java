package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ItTechnology;

import java.util.List;

public interface ItTechnologyService {
    DataResult<List<ItTechnology>> getAll();
    Result add(ItTechnology itTechnology);
}
