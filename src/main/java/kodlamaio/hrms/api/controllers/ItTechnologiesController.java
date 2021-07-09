package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ItTechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.ItTechnology;
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
@RequestMapping("/api/itTechnologies/")
public class ItTechnologiesController {
    private ItTechnologyService itTechnologyService;

    @Autowired
    public ItTechnologiesController(ItTechnologyService itTechnologyService) {
        this.itTechnologyService = itTechnologyService;
    }

    @GetMapping("/getAll")
    public DataResult<List<ItTechnology>> getAll() {
        return itTechnologyService.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody ItTechnology itTechnology){
        return ResponseEntity.ok(itTechnologyService.add(itTechnology));
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
