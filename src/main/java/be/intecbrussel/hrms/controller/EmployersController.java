package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.EmployerService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.EmployerUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/employers/")
@CrossOrigin
public class EmployersController {

    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        super();
        this.employerService = employerService;
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntityReturn.checkResult(this.employerService.getAll());
    }

    @GetMapping("getByMailIsVerifyTrue")
    public ResponseEntity<?> getByMailIsVerifyTrue() {
        return ResponseEntityReturn.checkResult(this.employerService.getByMailIsVerifyTrue());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(@RequestParam int userId) {
        return ResponseEntityReturn.checkResult(this.employerService.getByUserId(userId));
    }

    @PutMapping("updateEmployer")
    public ResponseEntity<?> updateEmployer(@RequestBody EmployerUpdate employerUpdate) {
        return ResponseEntityReturn.checkResult(this.employerService.updateEmployer(employerUpdate));
    }
}
