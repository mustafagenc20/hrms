package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.AuthService;
import be.intecbrussel.hrms.service.abstracts.EmployerService;
import be.intecbrussel.hrms.service.abstracts.UnemployedService;
import be.intecbrussel.hrms.service.abstracts.VerificationService;
import be.intecbrussel.hrms.core.abstracts.EmailService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.EmployeeDao;
import be.intecbrussel.hrms.repository.EmployerDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.repository.UserDao;
import be.intecbrussel.hrms.model.entities.User;
import be.intecbrussel.hrms.model.dtos.EmployerRegisterDto;
import be.intecbrussel.hrms.model.dtos.LoginDto;
import be.intecbrussel.hrms.model.dtos.LoginReturnDto;
import be.intecbrussel.hrms.model.dtos.UnemployedRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private UnemployedService unemployedService;
    private EmployerService employerService;
    private VerificationService verificationService;
    private EmailService emailService;

    private UserDao userDao;
    private UnemployedDao unemployedDao;
    private EmployerDao employerDao;
    private EmployeeDao employeeDao;

    @Autowired
    public AuthManager(UnemployedService unemployedService, EmployerService employerService,
                       VerificationService verificationService, UserDao userDao, UnemployedDao unemployedDao,
                       EmployerDao employerDao, EmployeeDao employeeDao, EmailService emailService) {
        super();
        this.unemployedService = unemployedService;
        this.employerService = employerService;
        this.verificationService = verificationService;
        this.emailService = emailService;

        this.userDao = userDao;
        this.unemployedDao = unemployedDao;
        this.employerDao = employerDao;
        this.employeeDao = employeeDao;
    }

    @Override
    public Result confirmPassword(String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            return new SuccessResult("Password verified.");
        }
        return new ErrorResult("Password does not match.");
    }

    @Override
    public Result checkEmail(String email) {
        if (this.userDao.findByEmail(email) == null) {
            return new SuccessResult();
        }
        return new ErrorResult("E-mail exist.");
    }

    @Override
    public DataResult<EmployerRegisterDto> registerEmployer(EmployerRegisterDto employerDto, String confirmPassword) {

        if (!this.checkEmail(employerDto.getEmail()).isSuccess()) {
            return new ErrorDataResult<EmployerRegisterDto>("The e-mail address has already been taken");
        }
        if (this.confirmPassword(employerDto.getPassword(), confirmPassword).isSuccess()) {
            Result result = this.employerService.addEmployer(employerDto);
            if(result.isSuccess()) {
                User user = this.employerDao.getByEmail(employerDto.getEmail());
                this.emailService.sendVerifyEmail(user, this.verificationService.generateCode(user));
                return new SuccessDataResult<EmployerRegisterDto>(employerDto,
                        "Registration successful. A verification link has been sent to your e-mail address");
            }
            return new ErrorDataResult<EmployerRegisterDto>(result.getMessage());
        }
        return new ErrorDataResult<EmployerRegisterDto>("Password does not match. Check and try again.");
    }

    @Override
    public DataResult<UnemployedRegisterDto> registerUnemployed(UnemployedRegisterDto unemployedDto,
                                                                String confirmPassword) {
        if (!this.checkEmail(unemployedDto.getEmail()).isSuccess()) {
            return new ErrorDataResult<UnemployedRegisterDto>("The e-mail address has already been taken.");
        }
        if (this.confirmPassword(unemployedDto.getPassword(), confirmPassword).isSuccess()) {
            Result result = this.unemployedService.addUnemployed(unemployedDto);
            if (result.isSuccess()) {
                User user = this.unemployedDao.getByEmail(unemployedDto.getEmail());
                this.emailService.sendVerifyEmail(user, this.verificationService.generateCode(user));
                return new SuccessDataResult<UnemployedRegisterDto>(unemployedDto,
                        "Registration successful. A verification link has been sent to your e-mail address.");
            }
            return new ErrorDataResult<UnemployedRegisterDto>(result.getMessage());
        }
        return new ErrorDataResult<UnemployedRegisterDto>(
                "Registration failed. Please check the information and try again.");
    }

    @Override
    public DataResult<LoginReturnDto> login(LoginDto loginDto) {
        User user = this.userDao.findByEmail(loginDto.getEmail().toString());
        if (user == null) {
            return new ErrorDataResult<LoginReturnDto>("Email address is incorrect or not registered");
        } else if (!user.getPassword().equals(loginDto.getPassword())) {
            return new ErrorDataResult<LoginReturnDto>("You entered an incorrect password");
        } else if (!user.getMailIsVerify()) {
            return new ErrorDataResult<LoginReturnDto>("To log in, you need to confirm your e-mail address");
        }

        LoginReturnDto loginReturnDto = new LoginReturnDto();
        loginReturnDto.setId(user.getUserId());
        loginReturnDto.setEmail(user.getEmail());

        if (this.unemployedDao.existsById(user.getUserId())) {
            loginReturnDto.setUserType(1);
            loginReturnDto.setName(this.unemployedDao.getOne(user.getUserId()).getFirstName() + " "
                    + this.unemployedDao.getOne(user.getUserId()).getLastName());
        } else if (this.employerDao.existsById(user.getUserId())) {
            loginReturnDto.setUserType(2);
            loginReturnDto.setName(this.employerDao.getOne(user.getUserId()).getCompanyName());
        } else if (this.employeeDao.existsById(user.getUserId())) {
            loginReturnDto.setUserType(3);
            loginReturnDto.setName(this.employeeDao.getOne(user.getUserId()).getFirstName() + " "
                    + this.employeeDao.getOne(user.getUserId()).getLastName());
        } else {
            return new ErrorDataResult<LoginReturnDto>("Login failed. Check the information and try again.");
        }

        return new SuccessDataResult<LoginReturnDto>(loginReturnDto, "Signed In.");
    }
}
