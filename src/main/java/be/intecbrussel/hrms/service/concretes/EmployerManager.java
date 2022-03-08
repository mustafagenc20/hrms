package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.EmployerService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.EmployerDao;
import be.intecbrussel.hrms.repository.EmployerUpdateDao;
import be.intecbrussel.hrms.model.entities.Employer;
import be.intecbrussel.hrms.model.entities.EmployerUpdate;
import be.intecbrussel.hrms.model.dtos.EmployerRegisterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerManager implements EmployerService {

    private final EmployerDao employerDao;
    private final EmployerUpdateDao updateDao;

    @Override
    public Result addEmployer(EmployerRegisterDto employerDto) {
        if (this.checkEmailDomain(employerDto.getEmail(), employerDto.getWebSite()).isSuccess()) {
            Employer employer = new Employer();
            employer.setCompanyName(employerDto.getCompanyName());
            employer.setWebSite(employerDto.getWebSite());
            employer.setEmail(employerDto.getEmail());
            employer.setPassword(employerDto.getPassword());
            employer.setPhoneNumber(employerDto.getPhoneNumber());
            this.employerDao.save(employer);
            return new SuccessResult("The registration is successful");
        }
        return new ErrorResult("Domain verification failed, please try again");
    }

    @Override
    public Result updateEmployer(EmployerUpdate employerUpdate) {
        employerUpdate.setEmployeeId(null);
        if (!this.employerDao.existsById(employerUpdate.getEmployerId())) {
            return new ErrorResult("The employer could not be found");
        }
        Employer employer = this.employerDao.getOne(employerUpdate.getEmployerId());
        if (this.updateDao.getByEmployerIdAndApproveStatusFalse(employer.getUserId()) != null) {
            return new ErrorResult("You have already created a request");
        }
        this.updateDao.save(employerUpdate);
        employer.setWaitingForUpdate(true);
        this.employerDao.save(employer);
        return new SuccessResult(
                "Your update request has been received. It will be approved after being checked by the relevant personnel");
    }

    @Override
    public Result checkEmailDomain(String email, String domain) {
        String[] mails = email.split("@", 2);
        String web = domain.substring(4);
        if (mails[1].equals(web)) {
            return new SuccessResult("Domain check successful");
        }
        return new ErrorResult("Domain check failed.");
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Employers are listed");
    }

    @Override
    public DataResult<List<Employer>> getByMailIsVerifyTrue() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.getByMailIsVerifyTrue());
    }

    @Override
    public DataResult<Employer> getByUserId(int userId) {
        return new SuccessDataResult<Employer>(this.employerDao.getByUserId(userId));
    }
}
