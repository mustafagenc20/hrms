package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.JobAdvertFavoriteService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller/jobAdvertFavorites/")
@CrossOrigin
public class JobAdvertFavoritesController {

    private JobAdvertFavoriteService advertFavoriteService;

    @Autowired
    public JobAdvertFavoritesController(JobAdvertFavoriteService advertFavoriteService) {
        super();
        this.advertFavoriteService = advertFavoriteService;
    }

    @PostMapping("addFavorite")
    public ResponseEntity<?> addFavorite(@RequestParam int unemployedId, int advertId) {
        return ResponseEntityReturn.checkResult(this.advertFavoriteService.addFavorite(unemployedId, advertId));
    }

    @DeleteMapping("deleteFavorite")
    public ResponseEntity<?> deleteFavorite(@RequestParam int favoriteId) {
        return ResponseEntityReturn.checkResult(this.advertFavoriteService.deleteFavorite(favoriteId));
    }

    @GetMapping("getByUnemployed")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.advertFavoriteService.getByUnemployedId(unemployedId));
    }
}
