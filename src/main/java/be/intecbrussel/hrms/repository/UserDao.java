package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User getByUserId(int userId);
    List<User> findByMailIsVerifyTrue();
}
