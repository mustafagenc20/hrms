package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
