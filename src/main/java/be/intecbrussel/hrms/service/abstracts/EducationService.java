package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Education;
import be.intecbrussel.hrms.model.dtos.EducationDto;

import java.util.List;

public interface EducationService {

    Result addEducation(EducationDto educationDto);
    Result updateEducation(EducationDto educationDto, int educationId);
    Result deleteEducation(int educationId);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> getByUnemployedIdOrderByGraduatedDateDesc(int unemployedId);
}
