package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.ConfirmingEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmingEmployerDao extends JpaRepository<ConfirmingEmployer, Integer> {
}
