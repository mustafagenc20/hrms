package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface PositionService {

    Result addPosition(Position position);
    DataResult<List<Position>> getAll();
    DataResult<Position> getByPositionName(String positionName);
}
