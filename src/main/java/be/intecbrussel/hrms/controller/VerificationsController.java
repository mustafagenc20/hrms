package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.VerificationService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/verification/")
@CrossOrigin
public class VerificationsController {

    private VerificationService verification;

    @Autowired
    public VerificationsController(VerificationService verification) {
        super();
        this.verification = verification;
    }

    @GetMapping("/approve/{code}")
    public ResponseEntity<?> verifyUser(@PathVariable String code) {
        return ResponseEntityReturn.checkResult(this.verification.verifyUser(code));
    }


}
