package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.ConfirmingEmployer;
import be.intecbrussel.hrms.model.entities.Employer;

import java.util.List;

public interface ConfirmingEmployerService {

    Result verifyEmployer (int employeeId, int employerId);
    DataResult<List<ConfirmingEmployer>> getAll();
    DataResult<List<Employer>> getByEmployerIsConfirmedFalse();
}
