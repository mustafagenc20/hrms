package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.CoverLetterService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.CoverLetterDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.CoverLetter;
import be.intecbrussel.hrms.model.dtos.CoverLetterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoverLetterManager implements CoverLetterService {

    private final CoverLetterDao coverLetterDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addCoverLetter(CoverLetterDto coverLetterDto) {
        if (this.coverLetterDao.getByUnemployed_UserId(coverLetterDto.getUnemployedId()) != null) {
            return new ErrorResult("You have already added a cover letter");
        }
        CoverLetter coverLetter = new CoverLetter();
        coverLetter.setLetterContent(coverLetterDto.getLetterContent());
        coverLetter.setUnemployed(this.unemployedDao.getOne(coverLetterDto.getUnemployedId()));

        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("Added cover letter");
    }

    @Override
    public DataResult<List<CoverLetter>> getAll() {
        return new SuccessDataResult<List<CoverLetter>>(this.coverLetterDao.findAll(), "The cover letters are listed");
    }

    @Override
    public DataResult<CoverLetter> getByUnemployedId(int unemployedId) {
        return new SuccessDataResult<CoverLetter>(this.coverLetterDao.getByUnemployed_UserId(unemployedId),
                "The cover letter of the job seeker is listed");
    }

    @Override
    public Result updateCoverLetter(CoverLetterDto coverLetterDto) {
        if (this.coverLetterDao.getByUnemployed_UserId(coverLetterDto.getUnemployedId()) == null) {
            return new ErrorResult("You must add a cover letter first");
        }
        CoverLetter coverLetter = this.coverLetterDao.getByUnemployed_UserId(coverLetterDto.getUnemployedId());
        if (coverLetter.getLetterContent().equals(coverLetterDto.getLetterContent())) {
            return new ErrorResult("You forgot to update");
        }
        coverLetter.setLetterContent(coverLetterDto.getLetterContent());
        this.coverLetterDao.save(coverLetter);
        return new SuccessResult("The cover letter has been updated");
    }
}
