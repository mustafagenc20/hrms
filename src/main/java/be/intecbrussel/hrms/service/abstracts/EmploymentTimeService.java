package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.EmploymentTime;

import java.util.List;

public interface EmploymentTimeService {

    DataResult<List<EmploymentTime>> getAll();
}
