package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.TechnologyService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.TechnologyDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Technology;
import be.intecbrussel.hrms.model.dtos.TechnologyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologyDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addTechnology(TechnologyDto technologyDto) {
        Technology technology = new Technology();
        if (this.technologyDao.getByTechnologyNameAndUnemployed_UserId(technologyDto.getTechnologyName(),
                technologyDto.getUnemployedId()) != null) {
            return new ErrorResult("You have already added this technology.");
        }
        technology.setTechnologyName(technologyDto.getTechnologyName());
        technology.setTechnologyLevel(technologyDto.getTechnologyLevel());
        technology.setUnemployed(this.unemployedDao.getOne(technologyDto.getUnemployedId()));

        this.technologyDao.save(technology);
        return new SuccessResult("Technology information added");
    }

    @Override
    public DataResult<List<Technology>> getAll() {
        return new SuccessDataResult<List<Technology>>(this.technologyDao.findAll(), "Technology information is listed");
    }

    @Override
    public DataResult<List<Technology>> getByUnemployedId(int unemployedId) {
        return new SuccessDataResult<List<Technology>>(this.technologyDao.getByUnemployed_UserId(unemployedId),
                "The job seeker's technology information is listed");
    }

    @Override
    public Result deleteTechnology(int technologyId) {
        if (!this.technologyDao.existsById(technologyId)) {
            return new ErrorResult("Technology information not found");
        }
        this.technologyDao.deleteById(technologyId);
        return new SuccessResult("Technology information has been deleted");
    }

    @Override
    public Result updateTechnology(TechnologyDto technologyDto, int technologyId) {
        Technology technology = this.technologyDao.getOne(technologyId);
        if (technology.getTechnologyLevel() == technologyDto.getTechnologyLevel()
                && technology.getTechnologyName() == technologyDto.getTechnologyName()) {
            return new ErrorResult("You did not make any changes.");
        }
        technology.setTechnologyName(technologyDto.getTechnologyName());
        technology.setTechnologyLevel(technologyDto.getTechnologyLevel());
        this.technologyDao.save(technology);
        return new SuccessResult("Technology information has been successfully updated");
    }
}
