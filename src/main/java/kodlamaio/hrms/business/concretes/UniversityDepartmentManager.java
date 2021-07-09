package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.UniversityDepartmentDao;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityDepartmentManager implements UniversityDepartmentService {
    private UniversityDepartmentDao universityDepartmentDao;

    @Autowired
    public UniversityDepartmentManager(UniversityDepartmentDao universityDepartmentDao) {
        this.universityDepartmentDao = universityDepartmentDao;
    }


    @Override
    public DataResult<List<UniversityDepartment>> getAll() {
        return new SuccessDataResult<>(universityDepartmentDao.findAll());
    }

    @Override
    public Result add(UniversityDepartment universityDepartment) {
        universityDepartmentDao.save(universityDepartment);
        return new SuccessResult("ekleme islemi tamamlandi");
    }
}
