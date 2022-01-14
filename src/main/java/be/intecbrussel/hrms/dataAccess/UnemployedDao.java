package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnemployedDao extends JpaRepository<Unemployed, Integer> {

    Unemployed getByUserId(int userId);
    Unemployed getByNationalityId(String nationalityId);
    Unemployed getByEmail(String email);
    List<Unemployed> getByMailIsVerifyTrue();
}
