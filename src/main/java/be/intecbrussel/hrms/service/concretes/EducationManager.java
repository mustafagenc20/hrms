package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.EducationService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.EducationDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Education;
import be.intecbrussel.hrms.model.dtos.EducationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationManager implements EducationService {

    private final EducationDao educationDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addEducation(EducationDto educationDto) {
        Education education = new Education();
        if (this.educationDao.getBySchoolNameAndDepartmentAndUnemployed_UserId(educationDto.getSchoolName(),
                educationDto.getDepartment(), educationDto.getUnemployedId()) != null) {
            return new ErrorResult("You have already added this school information");
        }
        education.setSchoolName(educationDto.getSchoolName());
        education.setDepartment(educationDto.getDepartment());
        education.setStartDate(educationDto.getStartDate());
        if (educationDto.getGraduatedDate() == null) {
            education.setGraduatedDate(null);
        } else {
            education.setGraduatedDate(educationDto.getGraduatedDate());
        }
        education.setUnemployed(this.unemployedDao.getOne(educationDto.getUnemployedId()));

        this.educationDao.save(education);
        return new SuccessResult("Education information added");
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return new SuccessDataResult<List<Education>>(this.educationDao.findAll(), "Education information is listed");
    }

    @Override
    public DataResult<List<Education>> getByUnemployedIdOrderByGraduatedDateDesc(int unemployedId) {
        return new SuccessDataResult<List<Education>>(
                this.educationDao.getByUnemployed_UserIdOrderByGraduatedDateDesc(unemployedId), "Continues");
    }

    @Override
    public Result deleteEducation(int educationId) {
        if (!this.educationDao.existsById(educationId)) {
            return new ErrorResult("School information not found");
        }
        this.educationDao.deleteById(educationId);
        return new SuccessResult("School information has been deleted");
    }

    @Override
    public Result updateEducation(EducationDto educationDto, int educationId) {
        Education education = this.educationDao.getOne(educationId);
        if (education.getSchoolName() == educationDto.getSchoolName()
                && education.getDepartment() == educationDto.getDepartment()
                && education.getStartDate() == educationDto.getStartDate()
                && education.getGraduatedDate() == educationDto.getGraduatedDate()) {
            return new ErrorResult("You did not make any changes");
        }
        education.setSchoolName(educationDto.getSchoolName());
        education.setDepartment(educationDto.getDepartment());
        education.setStartDate(educationDto.getStartDate());
        education.setGraduatedDate(education.getGraduatedDate());
        this.educationDao.save(education);
        return new SuccessResult("School information has been updated");
    }
}
