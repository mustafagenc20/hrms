package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {

    Technology getByTechnologyNameAndUnemployed_UserId(String technologyName, int unemployedId);
    Technology getByTechnologyName(String technologyName);
    List<Technology> getByUnemployed_UserId(int unemployedId);
}
