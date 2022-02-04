package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.ConfirmingUpdate;
import be.intecbrussel.hrms.model.entities.Employer;
import be.intecbrussel.hrms.model.entities.EmployerUpdate;

import java.util.List;

public interface ConfirmingUpdateService {

    Result verifyUpdate(int employeeId, int employerId, boolean status);
    DataResult<List<ConfirmingUpdate>> getAll();
    DataResult<List<EmployerUpdate>> getByApproveStatusFalse();
    DataResult<List<Employer>> getByWaitingForUpdateTrue();
}
