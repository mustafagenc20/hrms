package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {

    Language getByLanguageNameAndUnemployed_UserId(String languageName, int unemployedId);
    Language getByLanguageName(String languageName);
    List<Language> getByUnemployed_UserId(int unemployedId);
}
