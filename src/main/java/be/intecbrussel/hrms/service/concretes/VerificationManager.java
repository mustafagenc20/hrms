package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.VerificationService;
import be.intecbrussel.hrms.core.utilities.results.ErrorResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.core.utilities.results.SuccessResult;
import be.intecbrussel.hrms.repository.UserDao;
import be.intecbrussel.hrms.repository.VerificationDao;
import be.intecbrussel.hrms.model.entities.User;
import be.intecbrussel.hrms.model.entities.Verification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VerificationManager implements VerificationService {

    private final VerificationDao verificationDao;
    private final UserDao userDao;

    @Override
    public Result verifyUser(String code) {
        if(this.verificationDao.getByVerificationCode(code) != null ) {
            User user = this.userDao.getByUserId(verificationDao.getByVerificationCode(code).getUserId());
            Verification verify = this.verificationDao.getByUserId(user.getUserId());
            if (!user.getMailIsVerify()) {
                user.setMailIsVerify(true);
                verify.setVerified(true);
                this.userDao.save(user);
                this.verificationDao.save(verify);
                return new SuccessResult("The user has been successfully authenticated");
            }
        }
        return new ErrorResult("Verification failed.");
    }

    @Override
    public String generateCode(User user) {
        UUID code = UUID.randomUUID();
        Verification verify = new Verification();
        verify.setVerificationCode(code.toString());
        verify.setUserId(user.getUserId());
        this.verificationDao.save(verify);
        return code.toString();
    }
}
