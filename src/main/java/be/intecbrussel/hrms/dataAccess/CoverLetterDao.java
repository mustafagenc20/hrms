package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.CoverLetter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer> {

    CoverLetter getByUnemployed_UserId(int unemployedId);
    CoverLetter getByLetterContent(String letterContent);
}
