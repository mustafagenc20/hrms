package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {
}
