package be.intecbrussel.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService{

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        super();
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(), "Bütün kullanıcılar listelendi.");
    }

    @Override
    public DataResult<List<User>> getByMailConfirmed() {
        return new SuccessDataResult<List<User>>(this.userDao.findByMailIsVerifyTrue(), "Onaylanmış kullanıcılar listelendi.");
    }
}
