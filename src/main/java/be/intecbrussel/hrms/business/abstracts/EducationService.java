package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface EducationService {

    Result addEducation(EducationDto educationDto);
    Result updateEducation(EducationDto educationDto, int educationId);
    Result deleteEducation(int educationId);
    DataResult<List<Education>> getAll();
    DataResult<List<Education>> getByUnemployedIdOrderByGraduatedDateDesc(int unemployedId);
}
