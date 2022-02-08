package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.dtos.EmployerRegisterDto;
import be.intecbrussel.hrms.model.dtos.LoginDto;
import be.intecbrussel.hrms.model.dtos.LoginReturnDto;
import be.intecbrussel.hrms.model.dtos.UnemployedRegisterDto;

public interface AuthService {

    DataResult<UnemployedRegisterDto> registerUnemployed(UnemployedRegisterDto unemployedDto, String confirmPassword);
    DataResult<EmployerRegisterDto> registerEmployer(EmployerRegisterDto employerDto, String confirmPassword);

    DataResult<LoginReturnDto> login(LoginDto loginDto);

    Result confirmPassword(String password, String confirmPassword);
    Result checkEmail(String email);
}
