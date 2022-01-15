package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

    Employer getByEmail(String email);
    Employer getByUserId(int userId);
    List<Employer> getByMailIsVerifyTrue();
    List<Employer> getByEmployerIsConfirmedFalse();
    List<Employer> getByWaitingForUpdateTrue();
}
