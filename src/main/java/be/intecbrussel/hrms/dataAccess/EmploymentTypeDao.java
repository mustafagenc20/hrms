package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentTypeDao extends JpaRepository<EmploymentType, Integer> {
}
