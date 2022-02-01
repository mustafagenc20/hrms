package be.intecbrussel.hrms.api;

import be.intecbrussel.hrms.business.abstracts.LinkService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.entities.dtos.LinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/links/")
@CrossOrigin
public class LinksController {

    private LinkService linkService;

    @Autowired
    public LinksController(LinkService linkService) {
        super();
        this.linkService = linkService;
    }

    @PostMapping("addLink")
    public ResponseEntity<?> addLink(@RequestBody LinkDto linkDto) {
        return ResponseEntityReturn.checkResult(this.linkService.addLink(linkDto));
    }

    @PutMapping("updateLink")
    public ResponseEntity<?> updateLink(@RequestBody LinkDto linkDto) {
        return ResponseEntityReturn.checkResult(this.linkService.updateLink(linkDto));
    }

    @GetMapping("getAllLinks")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.linkService.getAll());
    }

    @GetMapping("getByUnemployed")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.linkService.getByUnemployedId(unemployedId));
    }
}
