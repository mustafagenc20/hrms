package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.JobAdvertFavorite;

import java.util.List;

public interface JobAdvertFavoriteService {

    Result addFavorite(int unemployedId, int advertId);
    Result deleteFavorite(int favoriteId);
    DataResult<List<JobAdvertFavorite>> getByUnemployedId(int unemployedId);
}
