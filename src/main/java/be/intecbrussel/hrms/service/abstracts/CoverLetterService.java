package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.CoverLetter;
import be.intecbrussel.hrms.model.dtos.CoverLetterDto;

import java.util.List;

public interface CoverLetterService {

    Result addCoverLetter(CoverLetterDto coverLetterDto);
    Result updateCoverLetter(CoverLetterDto coverLetterDto);
    DataResult<List<CoverLetter>> getAll();
    DataResult<CoverLetter> getByUnemployedId(int unemployedId);
}
