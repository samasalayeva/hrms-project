package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface EmailService {
    Result send(VerificationCode verificationCode);
    void confirm(VerificationCode verificationCode);
}
