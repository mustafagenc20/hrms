package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.dtos.CvDto;

public interface CvDtoService {

    DataResult<CvDto> createCv(int unemployedId);
}
