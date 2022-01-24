package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.entities.dtos.CvDto;

public interface CvDtoService {

    DataResult<CvDto> createCv(int unemployedId);
}
