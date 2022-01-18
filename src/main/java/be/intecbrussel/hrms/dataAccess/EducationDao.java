package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {

    Education getBySchoolNameAndDepartmentAndUnemployed_UserId(String schoolName, String departmen, int userId);
    List<Education> getByUnemployed_UserIdOrderByGraduatedDateDesc(int unemployedId);
}
