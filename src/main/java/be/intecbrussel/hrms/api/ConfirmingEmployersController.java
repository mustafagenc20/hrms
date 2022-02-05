package be.intecbrussel.hrms.api;

import be.intecbrussel.hrms.service.abstracts.ConfirmingEmployerService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.ConfirmingEmployer;
import be.intecbrussel.hrms.model.entities.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confirmingEmployer/")
@CrossOrigin
public class ConfirmingEmployersController {

    private ConfirmingEmployerService confirmingEmployerService;

    @Autowired
    public ConfirmingEmployersController(ConfirmingEmployerService confirmingEmployerService) {
        super();
        this.confirmingEmployerService = confirmingEmployerService;
    }

    @PostMapping("confirmEmployers")
    public ResponseEntity<?> confirmEmployers(@RequestParam int employeeId, int employerId) {
        return ResponseEntityReturn.checkResult(this.confirmingEmployerService.verifyEmployer(employeeId, employerId));
    }

    @GetMapping("getAllApprovedEmployers")
    public DataResult<List<ConfirmingEmployer>> getAll() {
        return this.confirmingEmployerService.getAll();
    }

    @GetMapping("getByEmployerIsConfirmed")
    public DataResult<List<Employer>> getByEmployerIsConfirmed() {
        return this.confirmingEmployerService.getByEmployerIsConfirmedFalse();
    }
}
