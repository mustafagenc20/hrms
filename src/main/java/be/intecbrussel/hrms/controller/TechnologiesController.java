package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.TechnologyService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.TechnologyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/technologies/")
@CrossOrigin
public class TechnologiesController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        super();
        this.technologyService = technologyService;
    }

    @PostMapping("addTechnology")
    public ResponseEntity<?> addTechnology(@RequestBody TechnologyDto technologyDto) {
        return ResponseEntityReturn.checkResult(this.technologyService.addTechnology(technologyDto));
    }

    @PutMapping("updateTechnology")
    public ResponseEntity<?> updateTechnology(@RequestBody TechnologyDto technologyDto, @RequestParam int technologyId) {
        return ResponseEntityReturn.checkResult(this.technologyService.updateTechnology(technologyDto, technologyId));
    }

    @DeleteMapping("deleteTechnology")
    public ResponseEntity<?> deleteTechnology(@RequestParam int technologyId) {
        return ResponseEntityReturn.checkResult(this.technologyService.deleteTechnology(technologyId));
    }

    @GetMapping("getAllTechnologies")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.technologyService.getAll());
    }

    @GetMapping("getByUnemployedId")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.technologyService.getByUnemployedId(unemployedId));
    }
}
