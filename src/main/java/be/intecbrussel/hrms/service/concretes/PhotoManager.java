package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.PhotoService;
import be.intecbrussel.hrms.core.abstracts.PhotoUploadService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.PhotoDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Photo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoManager implements PhotoService {

    private final PhotoDao photoDao;
    private final PhotoUploadService photoUploadService;
    private final UnemployedDao unemployedDao;

    private String defaultPhoto = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Breezeicons-actions-22-im-user.svg/512px-Breezeicons-actions-22-im-user.svg.png";


    @Override
    public Result uploadPhoto(int unemployedId, MultipartFile file) throws IOException {
        Photo photo = this.photoDao.getByUnemployed_UserId(unemployedId);
        var result = this.photoUploadService.upload(file);
        photo.setPhotoUrl(result.getData().get("url").toString());
        photo.setUploadDate(LocalDate.now());
        this.photoDao.save(photo);
        return new SuccessResult("The photo has been uploaded");
    }

    @Override
    public Result newRegister(int unemployedId) {
        Photo photo = new Photo();
        photo.setPhotoUrl(defaultPhoto);
        photo.setUploadDate(LocalDate.now());
        photo.setUnemployed(this.unemployedDao.getOne(unemployedId));
        this.photoDao.save(photo);
        return new SuccessResult();
    }

    @Override
    public Result deletePhoto(int unemployedId) {
        try {
            Photo photo = this.photoDao.getByUnemployed_UserId(unemployedId);
            this.photoUploadService.delete(photo.getPhotoId());
            photo.setPhotoUrl(defaultPhoto);
            this.photoDao.save(photo);
            return new SuccessResult("The photo was successfully deleted");
        } catch (IOException exception) {
            return new ErrorResult("The photo could not be deleted");
        }
    }

    @Override
    public DataResult<List<Photo>> getAll() {
        return new SuccessDataResult<List<Photo>>(this.photoDao.findAll(), "Photos listed");
    }

    @Override
    public DataResult<Photo> getByUnemployedId(int unemployedId) {
        if(this.photoDao.getByUnemployed_UserId(unemployedId) == null) {
            return new ErrorDataResult<Photo>("No photo found for the user you entered");
        }
        return new SuccessDataResult<Photo>(this.photoDao.getByUnemployed_UserId(unemployedId));
    }
}
