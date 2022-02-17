package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoDao extends JpaRepository<Photo, Integer> {

    Photo getByUnemployed_UserId(int unemployedId);
}
