package kodlamaio.hrms.core.adapters.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.adapters.abstracts.CloudinaryService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryManager implements CloudinaryService {
    private Cloudinary cloudinary;


    @Autowired
    public CloudinaryManager() {
        cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "diqzlvgkg",
                "api_key", "877415292243375",
                "api_secret", "H_6dUkemSgl1D5MME1ES8bZtD7k"));
    }

    @Override
    public DataResult<Map> uploadImageFile(MultipartFile imageFile) {
        try {
            @SuppressWarnings("unchecked")
            Map<String, String> resultMap = (Map<String, String>) cloudinary.uploader().upload(imageFile.getBytes(),
                    ObjectUtils.asMap("transformation",
                            (new Transformation().height(150).width(150).crop("scale")),
                            "unique_filename", "true",
                            "folder", "kodlamaio/profilePhotos/",
                            "allowed_formats", "jpg,jpeg,png"));
            return new SuccessDataResult<Map>(resultMap);
        } catch (IOException e) {
            e.printStackTrace();
            return new ErrorDataResult<Map>();

        }

    }
}
