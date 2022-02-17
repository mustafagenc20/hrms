package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Unemployed;
import be.intecbrussel.hrms.model.dtos.UnemployedRegisterDto;

import java.util.List;

public interface UnemployedService {

    Result addUnemployed(UnemployedRegisterDto unemployedDto);
    DataResult<Unemployed> getByUserId(int userId);
    DataResult<List<Unemployed>> getAll();
    DataResult<Unemployed> getByNationalityId(String nationalityId);
    DataResult<Unemployed> getByEmail(String email);
    DataResult<List<Unemployed>> getByMailIsVerifyTrue();
}
