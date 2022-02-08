package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.CityService;
import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.SuccessDataResult;
import be.intecbrussel.hrms.repository.CityDao;
import be.intecbrussel.hrms.model.entities.City;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityManager implements CityService {

    private final CityDao cityDao;

    @Override
    public DataResult<List<City>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"cityId");
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(sort));
    }
}
