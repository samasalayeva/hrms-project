package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.EmployerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    private EmailService loggerService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmailService loggerService) {
        this.employerDao = employerDao;
        this.loggerService = loggerService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(employerDao.findAll());
    }

    @Override
    public Result add(EmployerDto employerDto) {
        VerificationCode verificationCode = new VerificationCode();
        Result[] results = {UserValidation.passwordIsVerified(employerDto)
                , EmployerValidation.emailWebSiteIsVerified(employerDto)
                };

        Result result = BusinessResult.run(results);
        if (!result.isSuccess()) {
            return new ErrorResult(result.getMessage());
        }
        Employer employer = new Employer(employerDto.getEmail(),
                employerDto.getPassword(), capitalize(employerDto.getCompanyName()),
                employerDto.getWebSite(), employerDto.getPhoneNumber());
        employerDao.save(employer);
        loggerService.send(verificationCode);
        return new SuccessDataResult<>(employerDao.save(employer), "sisteme giris tamamlandi");
    }

    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
