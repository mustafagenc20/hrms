package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.CityService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller/cities/")
@CrossOrigin
public class CitiesController {

    private CityService cityService;

    @Autowired
    public CitiesController(CityService cityService) {
        super();
        this.cityService = cityService;
    }

    @GetMapping("getAllCities")
    public DataResult<List<City>> getAllCities() {
        return this.cityService.getAll();
    }
}
