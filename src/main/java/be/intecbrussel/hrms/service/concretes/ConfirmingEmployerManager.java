package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.ConfirmingEmployerService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessResult;
import be.intecbrussel.hrms.repository.ConfirmingEmployerDao;
import be.intecbrussel.hrms.repository.EmployeeDao;
import be.intecbrussel.hrms.repository.EmployerDao;
import be.intecbrussel.hrms.model.entities.ConfirmingEmployer;
import be.intecbrussel.hrms.model.entities.Employer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfirmingEmployerManager implements ConfirmingEmployerService {

    private final EmployeeDao employeeDao;
    private final ConfirmingEmployerDao confirmingEmployerDao;
    private final EmployerDao employerDao;

    @Override
    public Result verifyEmployer(int employeeId, int employerId) {

        Employer employer = this.employerDao.getOne(employerId);
        ConfirmingEmployer confirmEmployer = new ConfirmingEmployer();

        confirmEmployer.setEmployee(this.employeeDao.getOne(employeeId));
        confirmEmployer.setEmployer(this.employerDao.getOne(employerId));
        confirmEmployer.setVerifiedStatus(true);

        employer.setEmployerIsConfirmed(true);

        this.employerDao.save(employer);
        this.confirmingEmployerDao.save(confirmEmployer);

        return new SuccessResult("Employer approved.");
    }

    @Override
    public DataResult<List<ConfirmingEmployer>> getAll() {
        return new SuccessDataResult<List<ConfirmingEmployer>>(this.confirmingEmployerDao.findAll());
    }

    @Override
    public DataResult<List<Employer>> getByEmployerIsConfirmedFalse() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.getByEmployerIsConfirmedFalse(), "Unconfirmed employers are listed.");
    }
}
