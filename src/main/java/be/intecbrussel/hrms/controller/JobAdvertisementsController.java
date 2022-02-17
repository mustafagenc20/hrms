package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.JobAdvertisementService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;
import be.intecbrussel.hrms.model.dtos.JobAdvertFilterDto;
import be.intecbrussel.hrms.model.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/jobAdvertisements/")
@CrossOrigin
public class JobAdvertisementsController {

    private JobAdvertisementService advertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService advertisementService) {
        super();
        this.advertisementService = advertisementService;
    }

    @PostMapping("addAdvertisement")
    public ResponseEntity<?> add(@RequestBody JobAdvertisementDto advertisementDto) {
        return ResponseEntityReturn.checkResult(this.advertisementService.add(advertisementDto));
    }

    @PostMapping("getByApprovedAndFilter")
    public Result getByApprovedAndFilter(@RequestBody JobAdvertFilterDto advertFilterDto, @RequestParam int pageNo,
                                         int pageSize) {
        return advertisementService.getByAdvertIsConfirmedAndPageNumberAndFilter(pageNo, pageSize, advertFilterDto);
    }

    @PutMapping("changeAdvertisementStatus")
    public ResponseEntity<?> changeAdvertisementStatus(@RequestParam int advertId) {
        return ResponseEntityReturn.checkResult(this.advertisementService.changeAdvertisementStatus(advertId));
    }

    @GetMapping("getAll")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.advertisementService.getAll();
    }

    @GetMapping("getByAdvertStatusTrue")
    public DataResult<List<JobAdvertisement>> getByAdvertStatusTrue() {
        return this.advertisementService.getByAdvertStatusTrue();
    }

    @GetMapping("getByAdvertStatusFalseAndEmployerIdSorted")
    public ResponseEntity<?> getByAdvertStatusFalseAndEmployerIdSorted(@RequestParam int employerId) {
        return ResponseEntityReturn
                .checkResult(this.advertisementService.getByAdvertStatusAndEmployerIdSorted(employerId));
    }

    @GetMapping("getByAdvertStatusTrueAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByAdvertStatusTrueAndEmployerId(@RequestParam int employerId) {
        return this.advertisementService.getByAdvertStatusTrueAndEmployerId(employerId);
    }

    @GetMapping("getByAdvertIsConfirmed")
    public DataResult<List<JobAdvertisement>> getByAdvertIsConfirmed(@RequestParam boolean status) {
        return this.advertisementService.getByAdvertIsConfirmed(status);
    }

    @GetMapping("getByAdvertId")
    public DataResult<JobAdvertisement> getByAdvertId(@RequestParam int advertId) {
        return this.advertisementService.getByAdvertId(advertId);
    }

    @GetMapping("getByAdvertStatusAndAdvertIsConfirmedAndEmployerId")
    public DataResult<List<JobAdvertisement>> getByAdvertStatusAndAdvertIsConfirmedAndEmployerId(
            @RequestParam int employerId) {
        return this.advertisementService.getByAdvertStatusAndAdvertIsConfirmedAndEmployerId(employerId);
    }

    @GetMapping("getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployerId")
    public ResponseEntity<?> getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployerId(@RequestParam int employerId) {
        return ResponseEntityReturn.checkResult(
                this.advertisementService.getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployerId(employerId));
    }
}
