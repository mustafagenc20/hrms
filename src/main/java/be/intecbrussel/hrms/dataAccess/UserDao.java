package be.intecbrussel.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User getByUserId(int userId);
    List<User> findByMailIsVerifyTrue();
}
