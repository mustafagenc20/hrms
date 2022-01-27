package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.entities.concretes.EmploymentTime;

import java.util.List;

public interface EmploymentTimeService {

    DataResult<List<EmploymentTime>> getAll();
}
