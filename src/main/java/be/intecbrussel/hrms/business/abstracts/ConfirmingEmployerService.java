package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface ConfirmingEmployerService {

    Result verifyEmployer (int employeeId, int employerId);
    DataResult<List<ConfirmingEmployer>> getAll();
    DataResult<List<Employer>> getByEmployerIsConfirmedFalse();
}
