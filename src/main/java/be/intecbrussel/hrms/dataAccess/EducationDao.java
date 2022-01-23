package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    Education getBySchoolNameAndDepartmentAndUnemployed_UserId(String schoolName, String department, int userId);
    List<Education> getByUnemployed_UserIdOrderByGraduatedDateDesc(int unemployedId);
}
