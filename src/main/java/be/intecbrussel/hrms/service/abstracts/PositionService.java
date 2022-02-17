package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Position;

import java.util.List;

public interface PositionService {

    Result addPosition(Position position);
    DataResult<List<Position>> getAll();
    DataResult<Position> getByPositionName(String positionName);
}
