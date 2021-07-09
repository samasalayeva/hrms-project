package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.WorkExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.WorkExperience;
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
@RequestMapping("/api/workExperiences/")
public class WorkExperiencesController {
   private WorkExperienceService workExperienceService;

   @Autowired
    public WorkExperiencesController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    @GetMapping("getAll")
    public DataResult<List<WorkExperience>> getAll() {
        return workExperienceService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody WorkExperience workExperience){
        return ResponseEntity.ok(workExperienceService.add(workExperience));
    }
    @GetMapping("findByEndDateSorted")
    public DataResult<List<WorkExperience>> findByEndDate() {
        return workExperienceService.findByEndDate();
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
