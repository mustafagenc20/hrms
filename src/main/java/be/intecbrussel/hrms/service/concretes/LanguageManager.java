package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.LanguageService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.LanguageDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Language;
import be.intecbrussel.hrms.model.dtos.LanguageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addLanguage(LanguageDto languageDto) {
        Language language = new Language();
        if (this.languageDao.getByLanguageNameAndUnemployed_UserId(languageDto.getLanguageName(),
                languageDto.getUnemployedId()) != null) {
            return new ErrorResult("You have already added this language.");
        }
        language.setLanguageName(languageDto.getLanguageName());
        language.setLanguageLevel(languageDto.getLanguageLevel());
        language.setUnemployed(this.unemployedDao.getOne(languageDto.getUnemployedId()));

        this.languageDao.save(language);
        return new SuccessResult("Language added.");
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Languages listed.");
    }

    @Override
    public DataResult<List<Language>> getByUnemployedId(int unemployedId) {
        return new SuccessDataResult<List<Language>>(this.languageDao.getByUnemployed_UserId(unemployedId),
                "The job seeker's language information is listed.");
    }

    @Override
    public Result deleteLanguage(int languageId) {
        if (!this.languageDao.existsById(languageId)) {
            return new ErrorResult("Language information not found.");
        }
        this.languageDao.deleteById(languageId);
        return new SuccessResult("Language information has been deleted.");
    }

    @Override
    public Result updateLanguage(LanguageDto languageDto, int languageId) {
        Language language = this.languageDao.getOne(languageId);
        if (language.getLanguageLevel() == languageDto.getLanguageLevel()
                && language.getLanguageName() == languageDto.getLanguageName()) {
            return new ErrorResult("You did not make any changes.");
        }
        language.setLanguageName(languageDto.getLanguageName());
        language.setLanguageLevel(languageDto.getLanguageLevel());
        this.languageDao.save(language);
        return new SuccessResult("Language information has been updated successfully");
    }
}
