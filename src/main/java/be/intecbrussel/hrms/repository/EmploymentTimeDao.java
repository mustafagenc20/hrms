package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.EmploymentTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTimeDao extends JpaRepository<EmploymentTime, Integer> {
}
