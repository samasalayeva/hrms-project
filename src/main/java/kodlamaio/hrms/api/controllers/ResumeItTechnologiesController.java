package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeItTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.concretes.ResumeItTechnology;
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
@RequestMapping("/api/resumeItTechnologies")
public class ResumeItTechnologiesController {
    private ResumeItTechnologyService resumeItTechnologyService;

    @Autowired
    public ResumeItTechnologiesController(ResumeItTechnologyService resumeItTechnologyService) {
        this.resumeItTechnologyService = resumeItTechnologyService;
    }

    @GetMapping("getAll")
    public DataResult<List<ResumeItTechnology>> getAll() {
        return resumeItTechnologyService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody ResumeItTechnology resumeItTechnology) {
        return ResponseEntity.ok(resumeItTechnologyService.add(resumeItTechnology));
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
