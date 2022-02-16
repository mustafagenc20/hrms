package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.EmploymentTimeService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.repository.EmploymentTimeDao;
import be.intecbrussel.hrms.model.entities.EmploymentTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentTimeManager implements EmploymentTimeService {

    private final EmploymentTimeDao employmentTimeDao;

    @Override
    public DataResult<List<EmploymentTime>> getAll() {
        return new SuccessDataResult<List<EmploymentTime>>(this.employmentTimeDao.findAll());
    }
}
