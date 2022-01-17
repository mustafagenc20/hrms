package be.intecbrussel.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService{

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        Sort sort = Sort.by(Sort.Direction.ASC,"cityId");
        return new SuccessDataResult<List<City>>(this.cityDao.findAll(sort));
    }
}
