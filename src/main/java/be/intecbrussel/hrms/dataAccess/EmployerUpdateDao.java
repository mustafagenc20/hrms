package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.EmployerUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerUpdateDao extends JpaRepository<EmployerUpdate, Integer> {

    EmployerUpdate getByEmployerIdAndApproveStatusFalse(int employerId);
    List<EmployerUpdate> getByApproveStatusFalse();
}
