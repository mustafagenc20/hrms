package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.Employee;
import be.intecbrussel.hrms.entities.dtos.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    Result addEmployee(EmployeeDto employeeDto);
    Result updateEmployee(EmployeeDto employeeDto, int employeeId);
    Result deleteEmployee(int employeeId);
    DataResult<Employee> getByUserId(int userId);
    DataResult<List<Employee>> getAll();
}
