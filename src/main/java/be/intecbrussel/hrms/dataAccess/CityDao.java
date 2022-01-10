package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDao extends JpaRepository<City, Integer> {
}
