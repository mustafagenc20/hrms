package be.intecbrussel.hrms.core.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface PhotoUploadService {

    @SuppressWarnings("rawtypes")
    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;

    @SuppressWarnings("rawtypes")
    DataResult<Map> delete(int photoId) throws IOException;
}
