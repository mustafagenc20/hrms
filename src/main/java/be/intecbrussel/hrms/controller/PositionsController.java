package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.PositionService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import be.intecbrussel.hrms.model.entities.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/controller/positions")
@CrossOrigin
public class PositionsController {

    private PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        super();
        this.positionService = positionService;
    }

    @PostMapping("/addPosition")
    public ResponseEntity<?> addPosition (@RequestBody Position position) {
        return ResponseEntityReturn.checkResult(this.positionService.addPosition(position));
    }

    @GetMapping("/getall")
    public DataResult<List<Position>> getAll() {
        return this.positionService.getAll();
    }
}
