package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;

import java.util.List;

public interface UniversityDepartmentService {
    DataResult<List<UniversityDepartment>> getAll();
    Result add(UniversityDepartment universityDepartment);
}
