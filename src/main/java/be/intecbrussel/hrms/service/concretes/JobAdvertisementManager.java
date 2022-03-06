package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.JobAdvertisementService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.*;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;
import be.intecbrussel.hrms.model.dtos.JobAdvertFilterDto;
import be.intecbrussel.hrms.model.dtos.JobAdvertisementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao advertisementDao;
    private final CityDao cityDao;
    private final EmploymentTimeDao timeDao;
    private final EmploymentTypeDao typeDao;
    private final PositionDao positionDao;
    private final EmployerDao employerDao;

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "advertId");
        return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.findAll(sort));
    }

    @Override
    public Result add(JobAdvertisementDto advertisementDto) {

        JobAdvertisement jobAdvertisement = new JobAdvertisement();

        jobAdvertisement.setMinSalary(advertisementDto.getMinSalary());
        jobAdvertisement.setMaxSalary(advertisementDto.getMaxSalary());
        jobAdvertisement.setQuota(advertisementDto.getQuota());
        jobAdvertisement.setJobDescription(advertisementDto.getJobDescription());
        jobAdvertisement.setLastApplication(advertisementDto.getLastApplication());

        jobAdvertisement.setCity(this.cityDao.getOne(advertisementDto.getCityId()));
        jobAdvertisement.setEmploymentTime(this.timeDao.getOne(advertisementDto.getTimeId()));
        jobAdvertisement.setEmploymentType(this.typeDao.getOne(advertisementDto.getTypeId()));
        jobAdvertisement.setPosition(this.positionDao.getOne(advertisementDto.getPositionId()));
        jobAdvertisement.setEmployer(employerDao.getById(advertisementDto.getEmployerId()));

        if (advertisementDto.getMaxSalary() <= advertisementDto.getMinSalary()) {
            return new ErrorResult("The maximum salary cannot be equal to or lower than the minimum salary");
        }

        this.advertisementDao.save(jobAdvertisement);
        return new SuccessResult("New job posting added");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertStatusTrue() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.advertisementDao.getByAdvertStatusTrueOrderByAdvertIdAsc(), "Data listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertStatusAndEmployerIdSorted(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.advertisementDao.getByAdvertStatusFalseAndEmployer_UserIdOrderByCreatedDateAsc(employerId), "Data Listed");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertStatusTrueAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.advertisementDao.getByAdvertStatusTrueAndEmployer_UserId(employerId), "Data Listed");
    }

    @Override
    public Result changeAdvertisementStatus(int advertId) {
        JobAdvertisement advertisement = this.advertisementDao.getByAdvertId(advertId);
        if(advertisement.getAdvertStatus()) {
            advertisement.setAdvertStatus(false);
            this.advertisementDao.save(advertisement);
            return new SuccessResult("Job posting has been disabled");
        }
        advertisement.setAdvertStatus(true);
        this.advertisementDao.save(advertisement);
        return new SuccessResult("Job posting has been activated");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertIsConfirmed(boolean status) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.getByAdvertIsConfirmed(status));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertIsConfirmedAndPageNumberAndFilter(int pageNo, int pageSize,
                                                                                           JobAdvertFilterDto filterDto) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.advertisementDao.getByFilter(filterDto, pageable).getContent(),
                this.advertisementDao.getByFilter(filterDto, pageable).getTotalElements() + "");
    }

    @Override
    public DataResult<JobAdvertisement> getByAdvertId(int advertId) {
        return new SuccessDataResult<JobAdvertisement>(this.advertisementDao.getByAdvertId(advertId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertStatusAndAdvertIsConfirmedAndEmployerId(int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao
                .getByAdvertStatusTrueAndAdvertIsConfirmedTrueAndEmployer_UserIdOrderByCreatedDateAsc(employerId));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployerId(
            int employerId) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.getByAdvertStatusFalseAndAdvertIsConfirmedTrueAndEmployer_UserIdOrderByCreatedDateAsc(employerId));
    }
}
