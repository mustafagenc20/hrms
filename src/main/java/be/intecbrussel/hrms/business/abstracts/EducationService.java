package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.Education;
import be.intecbrussel.hrms.entities.dtos.EducationDto;

import java.util.List;

public interface EducationService {

    Result addEducation(EducationDto educationDto);
    Result updateEducation(EducationDto educationDto, int educationId);
    Result deleteEducation(int educationId);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> getByUnemployedIdOrderByGraduatedDateDesc(int unemployedId);
}
