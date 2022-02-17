package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {

    DataResult<List<EmploymentType>> getAll();
}
