package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.LinkDao;
import kodlamaio.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LinkManager implements LinkService {
    private LinkDao linkDao;

    @Autowired
    public LinkManager(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<>(linkDao.findAll());
    }

    @Override
    public Result add(Link link) {
        linkDao.save(link);
        return new SuccessResult("ekleme islemi basarili");
    }
}
