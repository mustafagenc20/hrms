package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDao extends JpaRepository<Position, Integer> {

    Position findByPositionName(String name);
}
