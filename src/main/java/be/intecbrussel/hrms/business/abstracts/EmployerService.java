package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface EmployerService {

    Result addEmployer(EmployerRegisterDto employerDto);
    Result updateEmployer(EmployerUpdate employerUpdate);
    Result checkEmailDomain(String email, String domain);
    DataResult<Employer> getByUserId(int userId);
    DataResult<List<Employer>> getAll();
    DataResult<List<Employer>> getByMailIsVerifyTrue();
}
