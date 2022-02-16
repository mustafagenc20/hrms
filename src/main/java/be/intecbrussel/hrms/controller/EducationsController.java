package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.EducationService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.EducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/educations/")
@CrossOrigin
public class EducationsController {

    private EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        super();
        this.educationService = educationService;
    }

    @PostMapping("addEducations")
    public ResponseEntity<?> addEducation(@RequestBody EducationDto educationDto) {
        return ResponseEntityReturn.checkResult(this.educationService.addEducation(educationDto));
    }

    @PutMapping("updateEducations")
    public ResponseEntity<?> updateEducaiton(@RequestBody EducationDto educationDto, @RequestParam int educationId) {
        return ResponseEntityReturn.checkResult(this.educationService.updateEducation(educationDto, educationId));
    }

    @DeleteMapping("deleteEducations")
    public ResponseEntity<?> deleteEducation(@RequestParam int educationId) {
        return ResponseEntityReturn.checkResult(this.educationService.deleteEducation(educationId));
    }

    @GetMapping("getAllEducations")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.educationService.getAll());
    }

    @GetMapping("getByUnemployedIdOrderByGraduatedDate")
    public ResponseEntity<?> getByUnemployedIdOrderByGraduatedDateDesc(@RequestParam int unemployedId) {
        return ResponseEntityReturn.checkResult(this.educationService.getByUnemployedIdOrderByGraduatedDateDesc(unemployedId));
    }
}
