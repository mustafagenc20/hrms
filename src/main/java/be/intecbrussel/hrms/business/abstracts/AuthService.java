package be.intecbrussel.hrms.business.abstracts;

public interface AuthService {

    DataResult<UnemployedRegisterDto> registerUnemployed(UnemployedRegisterDto unemployedDto, String confirmPassword);
    DataResult<EmployerRegisterDto> registerEmployer(EmployerRegisterDto employerDto, String confirmPassword);

    DataResult<LoginReturnDto> login(LoginDto loginDto);

    Result confirmPassword(String password, String confirmPassword);
    Result checkEmail(String email);
}
