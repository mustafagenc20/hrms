package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.JobExperience;
import be.intecbrussel.hrms.model.dtos.JobExperienceDto;

import java.util.List;

public interface JobExperienceService {

    Result addJobExperience(JobExperienceDto jobExperienceDto);
    Result updateJobExperience(JobExperienceDto jobExperienceDto, int experienceId);
    Result deleteJobExperience(int experienceId);
    DataResult<List<JobExperience>> getAll();
    DataResult<List<JobExperience>> getByUnemployedIdOrderByLeaveDateDesc(int unemployedId);
}
