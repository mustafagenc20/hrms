package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.ConfirmingJobAdvertisement;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;

import java.util.List;

public interface ConfirmingJobAdvertisementService {

    Result verifyAdvertisement (int employeeId, int advertId, boolean status);
    DataResult<List<ConfirmingJobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByAdvertIsConfirmedFalse();
}
