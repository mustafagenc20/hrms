package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Integer> {

    Position findByPositionName(String name);
}
