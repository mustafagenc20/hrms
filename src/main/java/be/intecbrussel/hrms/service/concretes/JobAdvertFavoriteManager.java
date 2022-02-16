package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.JobAdvertFavoriteService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.JobAdvertFavoriteDao;
import be.intecbrussel.hrms.repository.JobAdvertisementDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.JobAdvertFavorite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertFavoriteManager implements JobAdvertFavoriteService {

    private final JobAdvertisementDao advertisementDao;
    private final JobAdvertFavoriteDao favoriteDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addFavorite(int unemployedId, int advertId) {

        if(!this.unemployedDao.existsById(unemployedId)) {
            return new ErrorResult("User not found.");
        }else if (!this.advertisementDao.existsById(advertId)) {
            return new ErrorResult("Advertisement not found.");
        }else if(this.favoriteDao.existsByUnemployed_UserIdAndJobAdvertisement_AdvertId(unemployedId, advertId)) {
            return new ErrorResult("The advertisement has already been added to favourites.");
        }

        JobAdvertFavorite advertFavorite = new JobAdvertFavorite();
        advertFavorite.setUnemployed(this.unemployedDao.getOne(unemployedId));
        advertFavorite.setJobAdvertisement(this.advertisementDao.getOne(advertId));
        this.favoriteDao.save(advertFavorite);
        return new SuccessResult("The advertisement has been added to favourites.");
    }

    @Override
    public Result deleteFavorite(int favoriteId) {
        if(!this.favoriteDao.existsById(favoriteId)) {
            return new ErrorResult("The advertisement you want to delete is not found in favourites.");
        }
        this.favoriteDao.deleteById(favoriteId);
        return new SuccessResult("Advertisement has been successfully removed from favourites.");
    }

    @Override
    public DataResult<List<JobAdvertFavorite>> getByUnemployedId(int unemployedId) {
        if(!this.unemployedDao.existsById(unemployedId)) {
            return new ErrorDataResult<List<JobAdvertFavorite>>("The user you entered was not found.");
        }
        return new SuccessDataResult<List<JobAdvertFavorite>>(this.favoriteDao.getByUnemployed_UserId(unemployedId), "User's favorite postings are listed.");
    }
}
