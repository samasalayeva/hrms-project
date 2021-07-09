package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ItTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.ItTechnologyDao;
import kodlamaio.hrms.entities.concretes.ItTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItTechnologyManager implements ItTechnologyService {
    private ItTechnologyDao itTechnologyDao;

    @Autowired
    public ItTechnologyManager(ItTechnologyDao itTechnologyDao) {
        this.itTechnologyDao = itTechnologyDao;
    }

    @Override
    public DataResult<List<ItTechnology>> getAll() {
        return new SuccessDataResult<>(itTechnologyDao.findAll());
    }

    @Override
    public Result add(ItTechnology itTechnology) {
        itTechnologyDao.save(itTechnology);
        return new SuccessResult("ekleme islemi tamamlandi");
    }
}
