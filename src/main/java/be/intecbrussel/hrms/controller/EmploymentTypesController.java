package be.intecbrussel.hrms.controller;

import be.intecbrussel.hrms.service.abstracts.EmploymentTypeService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.EmploymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/controller/employmentTypes/")
@CrossOrigin
public class EmploymentTypesController {

    private EmploymentTypeService employmentTypeService;

    @Autowired
    public EmploymentTypesController(EmploymentTypeService employmentTypeService) {
        super();
        this.employmentTypeService = employmentTypeService;
    }

    @GetMapping("getAll")
    public DataResult<List<EmploymentType>> getAll() {
        return this.employmentTypeService.getAll();
    }
}
