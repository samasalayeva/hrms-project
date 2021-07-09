package kodlamaio.hrms.core.adapters.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface CloudinaryService {
    DataResult<Map> uploadImageFile(MultipartFile imageFile);

}
