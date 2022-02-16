package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.JobAdvertFavorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobAdvertFavoriteDao extends JpaRepository<JobAdvertFavorite, Integer> {

    List<JobAdvertFavorite> getByUnemployed_UserId(int unemployedId);
    boolean existsByUnemployed_UserIdAndJobAdvertisement_AdvertId(int unemployedId, int advertisementId);
}
