package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Link;

import java.util.List;

public interface LinkService {
    DataResult<List<Link>> getAll();
    Result add(Link link);
}
