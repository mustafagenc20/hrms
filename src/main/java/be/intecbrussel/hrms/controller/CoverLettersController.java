package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.CoverLetterService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.CoverLetterDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/coverletters/")
@CrossOrigin
public class CoverLettersController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLettersController(CoverLetterService coverLetterService) {
        super();
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("addCoverLetter")
    public ResponseEntity<?> addCoverLetter(@RequestBody CoverLetterDto coverLetterDto) {
        return ResponseEntityReturn.checkResult(this.coverLetterService.addCoverLetter(coverLetterDto));
    }

    @PutMapping("updateCoverLetter")
    public ResponseEntity<?> updateCoverLetter(@RequestBody CoverLetterDto coverLetterDto) {
        return ResponseEntityReturn.checkResult(this.coverLetterService.updateCoverLetter(coverLetterDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.coverLetterService.getAll());
    }

    @GetMapping("getByUnemployedId")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.coverLetterService.getByUnemployedId(unemployedId));
    }
}
