package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.ConfirmingUpdateService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/confirmingUpdates/")
@CrossOrigin
public class ConfirmingUpdatesController {

    private ConfirmingUpdateService updateService;

    @Autowired
    public ConfirmingUpdatesController(ConfirmingUpdateService updateService) {
        super();
        this.updateService = updateService;
    }

    @PostMapping("verifyUpdate")
    public ResponseEntity<?> verifyUpdate(@RequestParam int employeeId, int employerId, boolean status) {
        return ResponseEntityReturn.checkResult(this.updateService.verifyUpdate(employeeId, employerId, status));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.updateService.getAll());
    }

    @GetMapping("getByApproveStatus")
    public ResponseEntity<?> getByApproveStatus() {
        return ResponseEntity.ok(this.updateService.getByApproveStatusFalse());
    }

    @GetMapping("getByWaitingForUpdate")
    public ResponseEntity<?> getByWaitingForUpdate() {
        return ResponseEntity.ok(this.updateService.getByWaitingForUpdateTrue());
    }
}
