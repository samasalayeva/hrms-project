package kodlamaio.hrms.business.validate;


import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public class JobAdvertisementValidation {
    public static Result jobTitleValidate(JobAdvertisement jobAdvertisement){
        if(jobAdvertisement.getJobTitle().getTitle().isBlank() || jobAdvertisement.getJobTitle().getTitle().isBlank()) {
            return new ErrorResult("is pozisyonu alani bos birakilamaz");
        }

        return new SuccessResult();
    }
}
