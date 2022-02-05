package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.ConfirmationByEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationByEmployeeDao extends JpaRepository<ConfirmationByEmployee, Integer> {

    ConfirmationByEmployee findByEmployee_UserId(int employeeId);
}
