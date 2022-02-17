package be.intecbrussel.hrms.repository;

import be.intecbrussel.hrms.model.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link, Integer> {

    Link getByGithubLinkAndLinkedinLink(String githubLink, String linkedinLink);
    Link getByUnemployed_UserId(int unemployedId);
}
