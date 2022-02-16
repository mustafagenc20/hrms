package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.EmploymentTimeService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.EmploymentTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller/employmentTimes/")
@CrossOrigin
public class EmploymentTimesController {

    private EmploymentTimeService employmentTimeService;

    @Autowired
    public EmploymentTimesController(EmploymentTimeService employmentTimeService) {
        super();
        this.employmentTimeService = employmentTimeService;
    }

    @GetMapping("getAll")
    public DataResult<List<EmploymentTime>> getAll() {
        return this.employmentTimeService.getAll();
    }
}
