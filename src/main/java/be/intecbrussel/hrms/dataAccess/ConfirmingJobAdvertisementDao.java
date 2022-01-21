package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.ConfirmingJobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmingJobAdvertisementDao extends JpaRepository<ConfirmingJobAdvertisement, Integer>{
}
