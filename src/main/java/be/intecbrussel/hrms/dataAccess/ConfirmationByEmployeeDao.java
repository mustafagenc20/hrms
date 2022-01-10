package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationByEmployeeDao extends JpaRepository<ConfirmationByEmployee, Integer> {

    ConfirmationByEmployee findByEmployee_UserId(int employeeId);
}
