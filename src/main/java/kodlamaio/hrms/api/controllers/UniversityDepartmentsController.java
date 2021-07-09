package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.UniversityDepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.UniversityDepartment;
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
@RequestMapping("/api/universityDepartments/")
public class UniversityDepartmentsController {
    private UniversityDepartmentService universityDepartmentService;

    @Autowired
    public UniversityDepartmentsController(UniversityDepartmentService universityDepartmentService) {
        this.universityDepartmentService = universityDepartmentService;
    }

    @GetMapping("getAll")
    public DataResult<List<UniversityDepartment>> getAll() {
        return universityDepartmentService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody UniversityDepartment universityDepartment) {
        return ResponseEntity.ok(universityDepartmentService.add(universityDepartment));
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
