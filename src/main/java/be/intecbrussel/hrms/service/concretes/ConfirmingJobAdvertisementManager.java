package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.ConfirmingJobAdvertisementService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessResult;
import be.intecbrussel.hrms.repository.ConfirmingJobAdvertisementDao;
import be.intecbrussel.hrms.repository.EmployeeDao;
import be.intecbrussel.hrms.repository.JobAdvertisementDao;
import be.intecbrussel.hrms.model.entities.ConfirmingJobAdvertisement;
import be.intecbrussel.hrms.model.entities.JobAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConfirmingJobAdvertisementManager implements ConfirmingJobAdvertisementService {

    private final EmployeeDao employeeDao;
    private final ConfirmingJobAdvertisementDao confirmingJobAdvertisementDao;
    private final JobAdvertisementDao advertisementDao;

    @Override
    public Result verifyAdvertisement(int employeeId, int advertId, boolean status) {

        ConfirmingJobAdvertisement confirmAdvert = new ConfirmingJobAdvertisement();
        JobAdvertisement advertisement = this.advertisementDao.getOne(advertId);
        confirmAdvert.setEmployee(this.employeeDao.getOne(employeeId));
        confirmAdvert.setJobAdvertisement(this.advertisementDao.getOne(advertId));
        confirmAdvert.setVerifiedStatus(status);
        advertisement.setAdvertStatus(status);
        advertisement.setAdvertIsConfirmed(status);
        this.advertisementDao.save(advertisement);
        this.confirmingJobAdvertisementDao.save(confirmAdvert);

        if (status) {
            return new SuccessResult("You approved the advertisement.");
        } else {
            return new SuccessResult("You did not approve the advertisement.");
        }

    }

    @Override
    public DataResult<List<ConfirmingJobAdvertisement>> getAll() {
        return new SuccessDataResult<List<ConfirmingJobAdvertisement>>(this.confirmingJobAdvertisementDao.findAll());
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByAdvertIsConfirmedFalse() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.advertisementDao.getByAdvertIsConfirmedFalse(),
                "Disapproved are listed.");
    }
}
