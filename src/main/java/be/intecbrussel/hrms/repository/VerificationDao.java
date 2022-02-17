package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationDao extends JpaRepository<Verification, Integer>{

    Verification getByVerificationCode(String verificationCode);
    Verification getByUserId(int userId);
}
