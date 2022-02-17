package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.LanguageService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.dtos.LanguageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/languages/")
@CrossOrigin
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @PostMapping("addLanguage")
    public ResponseEntity<?> addLanguage(@RequestBody LanguageDto languageDto) {
        return ResponseEntityReturn.checkResult(this.languageService.addLanguage(languageDto));
    }

    @PutMapping("updateLanguage")
    public ResponseEntity<?> updateLanguage(@RequestBody LanguageDto languageDto, @RequestParam int languageId) {
        return ResponseEntityReturn.checkResult(this.languageService.updateLanguage(languageDto, languageId));
    }

    @DeleteMapping("deleteLanguage")
    public ResponseEntity<?> deleteLanguage(@RequestParam int languageId) {
        return ResponseEntityReturn.checkResult(this.languageService.deleteLanguage(languageId));
    }

    @GetMapping("getAllLanguages")
    public ResponseEntity<?> gettAll() {
        return ResponseEntity.ok(this.languageService.getAll());
    }

    @GetMapping("getByUnemployedId")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.languageService.getByUnemployedId(unemployedId));
    }
}
