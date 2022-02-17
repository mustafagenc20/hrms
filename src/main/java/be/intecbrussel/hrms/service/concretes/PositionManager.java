package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.PositionService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.PositionDao;
import be.intecbrussel.hrms.model.entities.Position;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionManager implements PositionService {

    private final PositionDao positionDao;

    private DataResult<Position> positionIsExist(String positionName) {
        return new SuccessDataResult<Position>(this.positionDao.findByPositionName(positionName));
    }

    @Override
    public Result addPosition(Position position) {
        if (this.positionIsExist(position.getPositionName()).getData() != null) {
            return new ErrorResult("The position is available.");
        }

        this.positionDao.save(position);
        return new SuccessResult("The position has been successfully added.");
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<List<Position>>(this.positionDao.findAll(), "Available positions are listed.");
    }

    @Override
    public DataResult<Position> getByPositionName(String positionName) {
        return new SuccessDataResult<Position>(this.positionDao.findByPositionName(positionName));
    }
}
