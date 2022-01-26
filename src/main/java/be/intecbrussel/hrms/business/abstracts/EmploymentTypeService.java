package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.entities.concretes.EmploymentType;

import java.util.List;

public interface EmploymentTypeService {

    DataResult<List<EmploymentType>> getAll();
}
