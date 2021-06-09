package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementController {
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("add")
    Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return jobAdvertisementService.add(jobAdvertisement);
    }

    @GetMapping("getAll")
    DataResult<List<JobAdvertisement>> getAll(){
     return jobAdvertisementService.getAll();
    }

    @GetMapping("getAllActiveIs")
    DataResult<List<JobAdvertisement>> findByActiveIs(){
        return jobAdvertisementService.findByActiveIs();
    }

    @GetMapping("findByActiveIsOrderByrApplicationDeadline")
    DataResult<List<JobAdvertisement>> findByActiveIsOrderApplicationDeadline(){
        return jobAdvertisementService.findByActiveIsOrderApplicationDeadline();
    }
    @GetMapping("findByActiveIsAndEmployer_Id")
    DataResult<List<JobAdvertisement>> findByActiveIsAndEmployer_Id(@RequestParam int employer_id){
        return jobAdvertisementService.findByActiveIsAndEmployer_Id(employer_id);
    }
    @GetMapping("isActiveOrIsPassive")
    Result isActiveOrIsPassive(@RequestParam int id,@RequestParam  boolean isActive){
        return jobAdvertisementService.isActiveOrIsPassive(id,isActive);
    }


}
