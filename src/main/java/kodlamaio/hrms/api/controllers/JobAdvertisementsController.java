package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementWithEmployerWithJobDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementsController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(jobAdvertisementService.add(jobAdvertisement));
    }

    @GetMapping("getAll")
    public DataResult<List<JobAdvertisement>> getAll(){
     return jobAdvertisementService.getAll();
    }

    @GetMapping("getAllActiveIs")
    public DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIs(){
        return jobAdvertisementService.findByActiveIs();
    }

    @GetMapping("findByActiveIsOrderByrApplicationDeadline")
    public DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIsOrderApplicationDeadline(){
        return jobAdvertisementService.findByActiveIsOrderApplicationDeadline();
    }
    @GetMapping("findByActiveIsAndEmployer_Id")
    public DataResult<List<JobAdvertisementWithEmployerWithJobDto>> findByActiveIsAndEmployer_Id(@RequestParam int employer_id){
        return jobAdvertisementService.findByActiveIsAndEmployer_Id(employer_id);
    }
    @PostMapping("isActiveOrIsPassive")
    public Result isActiveOrIsPassive(@RequestParam int id,@RequestParam  boolean isActive){
        return jobAdvertisementService.isActiveOrIsPassive(id,isActive);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handlerValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError:
                exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"dogrulama hatalari");
        return errors;
    }

}
