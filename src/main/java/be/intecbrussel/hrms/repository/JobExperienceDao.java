package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

    JobExperience getByWorkplaceNameAndPositionNameAndUnemployed_UserId(String workplaceName, String positionName, int unemployedId);
    List<JobExperience> getByUnemployed_UserIdOrderByLeaveDateDesc(int unemployedId);
}
