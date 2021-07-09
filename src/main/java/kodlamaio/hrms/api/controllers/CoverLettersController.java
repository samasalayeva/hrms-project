package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.CoverLetter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coverLetters/")
public class CoverLettersController {
    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @GetMapping("getAll")
     public DataResult<List<CoverLetter>> getAll() {
        return coverLetterService.getAll();
    }

    @PostMapping("add")
    public Result add(@RequestBody CoverLetter coverLetter) {
       coverLetterService.add(coverLetter);
        return new SuccessResult();
    }

}
