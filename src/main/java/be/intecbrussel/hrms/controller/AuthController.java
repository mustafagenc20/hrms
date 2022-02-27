package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.AuthService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.ErrorDataResult;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.EmployerRegisterDto;
import be.intecbrussel.hrms.model.dtos.LoginDto;
import be.intecbrussel.hrms.model.dtos.LoginReturnDto;
import be.intecbrussel.hrms.model.dtos.UnemployedRegisterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/controller/auth/")
@CrossOrigin
public class AuthController {

    private AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        super();
        this.authService = authService;
    }

    @PostMapping("registerEmployer")
    public ResponseEntity<?> registerEmployer(@Valid @RequestBody EmployerRegisterDto employerDto, @RequestParam String confirmPassword) {
        return ResponseEntityReturn.checkResult(this.authService.registerEmployer(employerDto, confirmPassword));
    }

    @PostMapping("registerUnemployed")
    public ResponseEntity<?> registerUnemployed(@Valid @RequestBody UnemployedRegisterDto unemployedDto, String confirmPassword) {
        return ResponseEntityReturn.checkResult(this.authService.registerUnemployed(unemployedDto, confirmPassword));
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
        DataResult<LoginReturnDto> loginReturnDto = this.authService.login(loginDto);
        if(loginReturnDto.isSuccess()) {
            return ResponseEntity.ok(loginReturnDto);
        }
        return ResponseEntity.badRequest().body(loginReturnDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Validation errors");
        return errors;
    }
}
