package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Technology;
import be.intecbrussel.hrms.model.dtos.TechnologyDto;

import java.util.List;

public interface TechnologyService {

    Result addTechnology(TechnologyDto technologyDto);
    Result updateTechnology(TechnologyDto technologyDto, int technologyId);
    Result deleteTechnology(int technologyId);
    DataResult<List<Technology>> getAll();
    DataResult<List<Technology>> getByUnemployedId(int unemployedId);
}
