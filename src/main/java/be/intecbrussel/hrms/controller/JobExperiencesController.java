package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.JobExperienceService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.JobExperienceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/jobexperiences/")
@CrossOrigin
public class JobExperiencesController {

    private JobExperienceService jobExperienceService;

    @Autowired
    public JobExperiencesController(JobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }

    @PostMapping("addJobExperience")
    public ResponseEntity<?> addJobExperience(@RequestBody JobExperienceDto jobExperienceDto) {
        return ResponseEntityReturn.checkResult(this.jobExperienceService.addJobExperience(jobExperienceDto));
    }

    @PutMapping("updateJobExperience")
    public ResponseEntity<?> updateJobExperience(@RequestBody JobExperienceDto jobExperienceDto, int experienceId) {
        return ResponseEntityReturn
                .checkResult(this.jobExperienceService.updateJobExperience(jobExperienceDto, experienceId));
    }

    @DeleteMapping("deleteJobExperience")
    public ResponseEntity<?> deleteJobExperience(@RequestParam int experienceId) {
        return ResponseEntityReturn.checkResult(this.jobExperienceService.deleteJobExperience(experienceId));
    }

    @GetMapping("getAllJobExperiences")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.jobExperienceService.getAll());
    }

    @GetMapping("getByUnemployedIdOrderByLeaveDate")
    public ResponseEntity<?> getByUnemployedIdOrderByLeaveDate(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.jobExperienceService.getByUnemployedIdOrderByLeaveDateDesc(unemployedId));
    }
}
