package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.EmploymentTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTimeDao extends JpaRepository<EmploymentTime, Integer> {
}
