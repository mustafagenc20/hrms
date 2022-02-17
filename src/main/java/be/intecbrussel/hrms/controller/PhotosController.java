package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.PhotoService;
import be.intecbrussel.hrms.core.utilities.util.ResponseEntityReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/controller/photos/")
@CrossOrigin
public class PhotosController {

    private PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) {
        super();
        this.photoService = photoService;
    }

    @PostMapping("uploadPhoto")
    public ResponseEntity<?> uploadPhoto(@RequestParam int unemployedId, MultipartFile multipartFile) throws IOException {
        return ResponseEntityReturn.checkResult(this.photoService.uploadPhoto(unemployedId, multipartFile));
    }

    @DeleteMapping("deletePhoto")
    public ResponseEntity<?> deletePhoto(@RequestParam int unemployedId) {
        return ResponseEntityReturn.checkResult(this.photoService.deletePhoto(unemployedId));
    }

    @GetMapping("getAllPhotos")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(this.photoService.getAll());
    }

    @GetMapping("getByUnemployedId")
    public ResponseEntity<?> getByUnemployedId(@RequestParam int unemployedId) {
        return ResponseEntity.ok(this.photoService.getByUnemployedId(unemployedId));
    }
}
