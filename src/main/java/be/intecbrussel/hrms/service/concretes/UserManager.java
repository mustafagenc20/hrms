package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.UserService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.repository.UserDao;
import be.intecbrussel.hrms.model.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService {

    private final UserDao userDao;

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "All users are listed.");
    }

    @Override
    public DataResult<List<User>> getByMailConfirmed() {
        return new SuccessDataResult<List<User>>(this.userDao.findByMailIsVerifyTrue(), "Approved users are listed");
    }
}
