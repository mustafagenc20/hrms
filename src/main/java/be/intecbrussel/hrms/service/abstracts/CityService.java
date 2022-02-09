package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.City;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
}
