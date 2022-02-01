package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.Language;
import be.intecbrussel.hrms.entities.dtos.LanguageDto;

import java.util.List;

public interface LanguageService {

    Result addLanguage(LanguageDto languageDto);
    Result updateLanguage(LanguageDto languageDto, int languageId);
    Result deleteLanguage(int languageId);
    DataResult<List<Language>> getAll();
    DataResult<List<Language>> getByUnemployedId(int unemployedId);
}
