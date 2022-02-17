package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.CvDtoService;
import be.intecbrussel.hrms.service.abstracts.UnemployedService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.Unemployed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/unemployeds/")
@CrossOrigin
public class UnemployedController {

    private UnemployedService unemployedService;
    private CvDtoService cvDtoService;

    @Autowired
    public UnemployedController(UnemployedService unemployedService, CvDtoService cvDtoService) {
        super();
        this.unemployedService = unemployedService;
        this.cvDtoService = cvDtoService;
    }

    @GetMapping("getall")
    public DataResult<List<Unemployed>> getAll() {
        return this.unemployedService.getAll();
    }

    @GetMapping("getMailIsVerifyTrue")
    public ResponseEntity<?> getByMailIsVerifyTrue() {
        return ResponseEntityReturn.checkResult(this.unemployedService.getByMailIsVerifyTrue());
    }

    @GetMapping("getByUserId")
    public ResponseEntity<?> getByUserId(@RequestParam int userId) {
        return ResponseEntityReturn.checkResult(this.unemployedService.getByUserId(userId));
    }

    @GetMapping("createCv")
    public ResponseEntity<?> createCv(@RequestParam int unemployedId) {
        return ResponseEntityReturn.checkResult(this.cvDtoService.createCv(unemployedId));
    }
}
