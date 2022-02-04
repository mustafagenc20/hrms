package be.intecbrussel.hrms.api;

import be.intecbrussel.hrms.service.abstracts.ConfirmingJobAdvertisementService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.ConfirmingJobAdvertisement;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confirmingJobAdverts/")
@CrossOrigin
public class ConfirmingJobAdvertisementsController {

    private ConfirmingJobAdvertisementService confirmJobAdvertService;

    @Autowired
    public ConfirmingJobAdvertisementsController (ConfirmingJobAdvertisementService confirmJobAdvertService) {
        super();
        this.confirmJobAdvertService = confirmJobAdvertService;
    }

    @PostMapping("confirmJobAdverts")
    public ResponseEntity<?> confirmJobAdvertisements(@RequestParam int employeeId, int advertId, boolean status) {
        return ResponseEntityReturn.checkResult(this.confirmJobAdvertService.verifyAdvertisement(employeeId, advertId, status));
    }

    @GetMapping("getAll")
    public DataResult<List<ConfirmingJobAdvertisement>> getAll() {
        return this.confirmJobAdvertService.getAll();
    }

    @GetMapping("getByAdvertIsConfirmed")
    public DataResult<List<JobAdvertisement>> getByAdvertIsConfirmed() {
        return this.confirmJobAdvertService.getByAdvertIsConfirmedFalse();
    }
}
