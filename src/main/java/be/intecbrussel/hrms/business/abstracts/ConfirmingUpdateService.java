package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.ConfirmingUpdate;
import be.intecbrussel.hrms.entities.concretes.Employer;
import be.intecbrussel.hrms.entities.concretes.EmployerUpdate;

import java.util.List;

public interface ConfirmingUpdateService {

    Result verifyUpdate(int employeeId, int employerId, boolean status);
    DataResult<List<ConfirmingUpdate>> getAll();
    DataResult<List<EmployerUpdate>> getByApproveStatusFalse();
    DataResult<List<Employer>> getByWaitingForUpdateTrue();
}
