package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.EmploymentTypeService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.repository.EmploymentTypeDao;
import be.intecbrussel.hrms.model.entities.EmploymentType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmploymentTypeManager implements EmploymentTypeService {

    private final EmploymentTypeDao employmentTypeDao;

    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<List<EmploymentType>>(this.employmentTypeDao.findAll());
    }
}
