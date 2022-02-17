package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;
import be.intecbrussel.hrms.model.dtos.JobAdvertFilterDto;
import be.intecbrussel.hrms.model.dtos.JobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {

    Result add(JobAdvertisementDto advertisementDto);
    Result changeAdvertisementStatus(int advertId);

    DataResult<JobAdvertisement> getByAdvertId(int advertId);
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByAdvertStatusTrue();
    DataResult<List<JobAdvertisement>> getByAdvertStatusAndEmployerIdSorted(int employerId);
    DataResult<List<JobAdvertisement>> getByAdvertIsConfirmed(boolean status);
    DataResult<List<JobAdvertisement>> getByAdvertStatusTrueAndEmployerId(int employerId);
    DataResult<List<JobAdvertisement>> getByAdvertStatusAndAdvertIsConfirmedAndEmployerId(int employerId);
    DataResult<List<JobAdvertisement>> getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployerId(int employerId);
    DataResult<List<JobAdvertisement>> getByAdvertIsConfirmedAndPageNumberAndFilter(int pageNo, int pageSize, JobAdvertFilterDto filterDto);
}
