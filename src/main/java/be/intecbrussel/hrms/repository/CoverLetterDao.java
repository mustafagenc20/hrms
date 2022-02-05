package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

    CoverLetter getByUnemployed_UserId(int unemployedId);
    CoverLetter getByLetterContent(String letterContent);
}
