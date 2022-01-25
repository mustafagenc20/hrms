package be.intecbrussel.hrms.business.concretes;

import be.intecbrussel.hrms.business.abstracts.EmployeeService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.dataAccess.EmployeeDao;
import be.intecbrussel.hrms.dataAccess.PositionDao;
import be.intecbrussel.hrms.dataAccess.UserDao;
import be.intecbrussel.hrms.entities.concretes.Employee;
import be.intecbrussel.hrms.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeManager implements EmployeeService {

    private EmployeeDao employeeDao;
    private UserDao userDao;
    private PositionDao positionDao;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, UserDao userDao, PositionDao positionDao) {
        super();
        this.employeeDao = employeeDao;
        this.userDao = userDao;
        this.positionDao = positionDao;
    }

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
