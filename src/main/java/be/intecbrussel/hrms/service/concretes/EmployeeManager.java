package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.EmployeeService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.EmployeeDao;
import be.intecbrussel.hrms.repository.PositionDao;
import be.intecbrussel.hrms.repository.UserDao;
import be.intecbrussel.hrms.model.entities.Employee;
import be.intecbrussel.hrms.model.dtos.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeDao employeeDao;
    private final UserDao userDao;
    private final PositionDao positionDao;

     @Override
    public Result addEmployee(EmployeeDto employeeDto) {
        if (this.userDao.findByEmail(employeeDto.getEmail()) != null) {
            return new ErrorResult("This e-mail address has already been taken.");
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPassword(employeeDto.getPassword());
        employee.setPosition(this.positionDao.getOne(employeeDto.getPositionId()));
        employee.setMailIsVerify(true);
        this.employeeDao.save(employee);
        return new SuccessResult("The staff has been successfully added.");
    }

    @Override
    public Result updateEmployee(EmployeeDto employeeDto, int employeeId) {
        Employee employee = this.employeeDao.getOne(employeeId);
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPosition(this.positionDao.getOne(employeeDto.getPositionId()));
        employee.setPassword(employeeDto.getPassword());
        this.employeeDao.save(employee);
        return new SuccessResult("Staff information has been updated.");
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<List<Employee>>(this.employeeDao.findAll(), "System personnel have been listed.");
    }

    @Override
    public DataResult<Employee> getByUserId(int userId) {
        return new SuccessDataResult<Employee>(this.employeeDao.getByUserId(userId));
    }

    @Override
    public Result deleteEmployee(int employeeId) {
        this.employeeDao.deleteById(employeeId);
        return new SuccessResult("The personnel has been deleted.");
    }
}
