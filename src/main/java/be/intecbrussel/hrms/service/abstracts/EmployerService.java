package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Employer;
import be.intecbrussel.hrms.model.entities.EmployerUpdate;
import be.intecbrussel.hrms.model.dtos.EmployerRegisterDto;

import java.util.List;

public interface EmployerService {

    Result addEmployer(EmployerRegisterDto employerDto);
    Result updateEmployer(EmployerUpdate employerUpdate);
    Result checkEmailDomain(String email, String domain);
    DataResult<Employer> getByUserId(int userId);
    DataResult<List<Employer>> getAll();
    DataResult<List<Employer>> getByMailIsVerifyTrue();
}
