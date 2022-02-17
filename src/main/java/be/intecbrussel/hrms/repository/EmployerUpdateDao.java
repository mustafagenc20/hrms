package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

    EmployerUpdate getByEmployerIdAndApproveStatusFalse(int employerId);
    List<EmployerUpdate> getByApproveStatusFalse();
}
