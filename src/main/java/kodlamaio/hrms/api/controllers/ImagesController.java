package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Image;
import kodlamaio.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/images/")
public class ImagesController {
    private ImageService imageService;
    private UserService userService;

    @Autowired
    public ImagesController(ImageService imageService, UserService userService) {
        this.imageService = imageService;
        this.userService = userService;
    }

    @PostMapping("add")
    public Result add(@RequestParam int id, @RequestParam MultipartFile imageFile){
        User user = userService.findById(id).getData();
        Image image = new Image();
        image.setUser(user);
        return this.imageService.add(image,imageFile);
    }

    @GetMapping("getAll")
    public DataResult<List<Image>> getAll(){
        return imageService.getAll();
    }

}
