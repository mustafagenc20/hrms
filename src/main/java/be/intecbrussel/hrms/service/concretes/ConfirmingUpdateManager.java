package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.ConfirmingUpdateService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessResult;
import be.intecbrussel.hrms.repository.ConfirmingUpdateDao;
import be.intecbrussel.hrms.repository.EmployeeDao;
import be.intecbrussel.hrms.repository.EmployerDao;
import be.intecbrussel.hrms.repository.EmployerUpdateDao;
import be.intecbrussel.hrms.model.entities.ConfirmingUpdate;
import be.intecbrussel.hrms.model.entities.Employer;
import be.intecbrussel.hrms.model.entities.EmployerUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfirmingUpdateManager implements ConfirmingUpdateService {

    private final EmployeeDao employeeDao;
    private final ConfirmingUpdateDao confirmingUpdateDao;
    private final EmployerDao employerDao;
    private final EmployerUpdateDao employerUpdateDao;

    @Override
    public Result verifyUpdate(int employeeId, int employerId, boolean status) {

        EmployerUpdate employerUpdate = this.employerUpdateDao.getByEmployerIdAndApproveStatusFalse(employerId);
        Employer employer = this.employerDao.getOne(employerId);
        ConfirmingUpdate confirmingUpdate = new ConfirmingUpdate();

        employerUpdate.setApproveStatus(true);
        employerUpdate.setEmployeeId(employeeId);

        this.employerUpdateDao.save(employerUpdate);

        employer.setPhoneNumber(employerUpdate.getPhoneNumber());
        employer.setEmail(employerUpdate.getEmail());
        employer.setCompanyName(employerUpdate.getCompanyName());
        employer.setWebSite(employerUpdate.getWebSite());
        employer.setWaitingForUpdate(false);

        this.employerDao.save(employer);

        confirmingUpdate.setEmployee(this.employeeDao.getOne(employeeId));
        confirmingUpdate.setEmployer(this.employerDao.getOne(employerId));
        confirmingUpdate.setEmployerUpdate(this.employerUpdateDao.getOne(employerUpdate.getUpdateId()));
        confirmingUpdate.setVerifiedStatus(status);

        this.confirmingUpdateDao.save(confirmingUpdate);

        return new SuccessResult("The update request has been approved.");
    }

    @Override
    public DataResult<List<ConfirmingUpdate>> getAll() {
        return new SuccessDataResult<List<ConfirmingUpdate>>(this.confirmingUpdateDao.findAll(), "All validation transactions are listed.");
    }

    @Override
    public DataResult<List<EmployerUpdate>> getByApproveStatusFalse() {
        return new SuccessDataResult<List<EmployerUpdate>>(this.employerUpdateDao.getByApproveStatusFalse(), "Listed according to approval status.");
    }

    @Override
    public DataResult<List<Employer>> getByWaitingForUpdateTrue() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.getByWaitingForUpdateTrue(), "Pending employers for approved are listed.");
    }
}
