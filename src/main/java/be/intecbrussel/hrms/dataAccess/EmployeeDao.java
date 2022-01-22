package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

    Employee getByUserId(int userId);
    Employee getByEmail(String email);
}