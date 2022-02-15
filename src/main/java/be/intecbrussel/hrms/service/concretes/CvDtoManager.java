package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.*;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.dtos.CvDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CvDtoManager implements CvDtoService {

    private final UnemployedDao unemployedDao;
    private final EducationService educationService;
    private final JobExperienceService jobExperienceService;
    private final TechnologyService technologyService;
    private final LanguageService languageService;
    private final LinkService linkService;
    private final CoverLetterService coverLetterService;
    private final PhotoService photoService;

    @Override
    public DataResult<CvDto> createCv(int unemployedId) {
        CvDto cv = new CvDto();
        cv.setUnemployed(this.unemployedDao.findById(unemployedId).get());
        cv.setEducations(this.educationService.getByUnemployedIdOrderByGraduatedDateDesc(unemployedId).getData());
        cv.setJobExperiences(this.jobExperienceService.getByUnemployedIdOrderByLeaveDateDesc(unemployedId).getData());
        cv.setTechnologies(this.technologyService.getByUnemployedId(unemployedId).getData());
        cv.setLanguages(this.languageService.getByUnemployedId(unemployedId).getData());
        cv.setLink(this.linkService.getByUnemployedId(unemployedId).getData());
        cv.setCoverLetter(this.coverLetterService.getByUnemployedId(unemployedId).getData());
        cv.setPhoto(this.photoService.getByUnemployedId(unemployedId).getData());
        return new SuccessDataResult<CvDto>(cv);
    }
}
