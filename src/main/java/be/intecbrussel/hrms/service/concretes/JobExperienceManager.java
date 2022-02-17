package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.JobExperienceService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.JobExperienceDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.JobExperience;
import be.intecbrussel.hrms.model.dtos.JobExperienceDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobExperienceManager implements JobExperienceService {

    private final JobExperienceDao jobExperienceDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addJobExperience(JobExperienceDto jobExperienceDto) {

        JobExperience experience = new JobExperience();
        experience.setWorkplaceName(jobExperienceDto.getWorkplaceName());
        experience.setPositionName(jobExperienceDto.getPositionName());
        experience.setStartDate(jobExperienceDto.getStartDate());
        experience.setLeaveDate(jobExperienceDto.getLeaveDate());
        experience.setUnemployed(this.unemployedDao.getOne(jobExperienceDto.getUnemployedId()));

        this.jobExperienceDao.save(experience);
        return new SuccessResult("Work experience added.");
    }

    @Override
    public Result deleteJobExperience(int experienceId) {
        if (!this.jobExperienceDao.existsById(experienceId)) {
            return new ErrorResult("Work experience information not found.");
        }
        this.jobExperienceDao.deleteById(experienceId);
        return new SuccessResult("Work experience information has been deleted.");
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(this.jobExperienceDao.findAll(),
                "Work experience is listed.");
    }

    @Override
    public DataResult<List<JobExperience>> getByUnemployedIdOrderByLeaveDateDesc(int unemployedId) {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceDao.getByUnemployed_UserIdOrderByLeaveDateDesc(unemployedId), "Continues.");
    }

    @Override
    public Result updateJobExperience(JobExperienceDto jobExperienceDto, int experienceId) {
        JobExperience jobExperience = this.jobExperienceDao.getOne(experienceId);
        if (jobExperience.getWorkplaceName() == jobExperienceDto.getWorkplaceName()
                && jobExperience.getPositionName() == jobExperienceDto.getPositionName()
                && jobExperience.getStartDate() == jobExperienceDto.getStartDate()
                && jobExperience.getLeaveDate() == jobExperienceDto.getLeaveDate()) {
            return new ErrorResult("You did not make any changes.");
        }
        jobExperience.setWorkplaceName(jobExperienceDto.getWorkplaceName());
        jobExperience.setPositionName(jobExperienceDto.getPositionName());
        jobExperience.setStartDate(jobExperienceDto.getStartDate());
        jobExperience.setLeaveDate(jobExperienceDto.getLeaveDate());
        this.jobExperienceDao.save(jobExperience);
        return new SuccessResult("Work experience information has been updated.");
    }
}
