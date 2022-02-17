package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PhotoService {

    Result uploadPhoto(int unemployedId, MultipartFile file) throws IOException;
    Result newRegister(int unemployedId);
    Result deletePhoto(int unemployedId);
    DataResult<List<Photo>> getAll();
    DataResult<Photo> getByUnemployedId(int unemployedId);
}
