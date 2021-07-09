package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAcces.ImageDao;
import kodlamaio.hrms.entities.concretes.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private CloudinaryService cloudinaryService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryService cloudinaryService) {
        this.imageDao = imageDao;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public Result add(Image image, MultipartFile imageFile) {
        @SuppressWarnings("unchecked")
        Map<String,String> uploadImage = this.cloudinaryService.uploadImageFile(imageFile).getData();

        image.setImageUrl(uploadImage.get("url"));
        this.imageDao.save(image);
        return new SuccessResult("fotoraf sisteme eklendi.");
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return new SuccessDataResult<>(imageDao.findAll());
    }
}
