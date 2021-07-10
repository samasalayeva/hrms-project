package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.adapters.abstracts.EmailService;
import kodlamaio.hrms.core.adapters.abstracts.MernisService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAcces.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateDto;
import kodlamaio.hrms.entities.dtos.ResumeDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;
    private EmailService emailService;
    private MernisService mernisService;
    private ModelMapper modelMapper;


    @Autowired
    public CandidateManager(CandidateDao candidateDao, EmailService emailService, MernisService mernisService, ModelMapper modelMapper) {
        this.candidateDao = candidateDao;
        this.emailService = emailService;
        this.mernisService = mernisService;
        this.modelMapper = modelMapper;
    }


    @Override
    public DataResult<List<Candidate>> getAll() {

        return new SuccessDataResult<>(candidateDao.findAll());
    }

    @Override
    public Result add(CandidateDto candidateDto) {
        VerificationCode verificationCode = new VerificationCode();
        Result[] results = {
                  CandidateValidation.findIdentity(candidateDto, candidateDao)
                , CandidateValidation.findEmail(candidateDto, candidateDao)
                , mernisService.isIdentity(candidateDto)
                , CandidateValidation.compareFormat(candidateDto)};
        Result result = BusinessResult.run(results);
        if (!result.isSuccess()) {
            return new ErrorDataResult<>(result.getMessage());
        }
        Candidate candidate = new Candidate(candidateDto.getEmail(), candidateDto.getPassword(),
                capitalize(candidateDto.getFirstName()), capitalize(candidateDto.getLastName()),
                LocalDate.parse(candidateDto.getBirthOfDate()), candidateDto.getIdentityNumber());

        candidateDao.save(candidate);
        emailService.send(verificationCode);
        return new SuccessDataResult<>(candidate,"Sisteme kayd gerceklesdi lutfen epostanizi dogrulayin");

    }

    @Override
    public DataResult<ResumeDto> findById(int id) {
        Candidate candidate = candidateDao.findById(id);
        ResumeDto resumeDto = modelMapper.map(candidate,ResumeDto.class);
        return new SuccessDataResult<>(resumeDto);
    }

    public static String capitalize(String str)
    {
        if(str == null) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
