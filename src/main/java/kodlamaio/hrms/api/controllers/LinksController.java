package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.LinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;import kodlamaio.hrms.entities.concretes.Candidate;

import java.util.Map;

@RestController
@RequestMapping("/api/links/")
public class LinksController {
    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        this.linkService = linkService;
    }

    @GetMapping("getAll")
    public DataResult<List<Link>> getAll() {
        return linkService.getAll();
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody Link link){
        return ResponseEntity.ok(linkService.add(link));
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
