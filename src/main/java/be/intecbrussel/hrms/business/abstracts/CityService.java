package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface CityService {

    DataResult<List<City>> getAll();
}
