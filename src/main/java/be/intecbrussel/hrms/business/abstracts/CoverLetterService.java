package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.entities.concretes.CoverLetter;
import be.intecbrussel.hrms.entities.dtos.CoverLetterDto;

import java.util.List;

public interface CoverLetterService {

    Result addCoverLetter(CoverLetterDto coverLetterDto);
    Result updateCoverLetter(CoverLetterDto coverLetterDto);
    DataResult<List<CoverLetter>> getAll();
    DataResult<CoverLetter> getByUnemployedId(int unemployedId);
}
