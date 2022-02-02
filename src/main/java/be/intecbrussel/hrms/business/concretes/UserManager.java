package be.intecbrussel.hrms.business.concretes;

import be.intecbrussel.hrms.business.abstracts.UserService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.dataAccess.UserDao;
import be.intecbrussel.hrms.entities.concretes.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new SuccessDataResult<List<User>>(this.userDao.findByMailIsVerifyTrue(), "Approved users are listed.");
    }
}
