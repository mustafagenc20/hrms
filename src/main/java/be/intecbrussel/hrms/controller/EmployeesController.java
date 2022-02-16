package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.EmployeeService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/employees/")
@CrossOrigin
public class EmployeesController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeesController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping("addEmployee")
    public ResponseEntity<?> addEmployee(@RequestBody EmployeeDto employeeDto) {
        return ResponseEntityReturn.checkResult(this.employeeService.addEmployee(employeeDto));

    }

    @PutMapping("updateEmployee")
    public ResponseEntity<?> updateEmployee(@RequestBody EmployeeDto employeeDto, @RequestParam int employeeId) {
        return ResponseEntityReturn.checkResult(this.employeeService.updateEmployee(employeeDto, employeeId));
    }

    @DeleteMapping("deleteEmployee")
    public ResponseEntity<?> deleteEmployee(@RequestParam int employeeId) {
        return ResponseEntityReturn.checkResult(this.employeeService.deleteEmployee(employeeId));
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(@RequestParam int userId) {
        return ResponseEntityReturn.checkResult(this.employeeService.getByUserId(userId));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntityReturn.checkResult(this.employeeService.getAll());
    }

}
