package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.ConfirmingEmployer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmingEmployerDao extends JpaRepository<ConfirmingEmployer, Integer> {
}
