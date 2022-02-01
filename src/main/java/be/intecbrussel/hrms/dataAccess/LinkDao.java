package be.intecbrussel.hrms.dataAccess;

import be.intecbrussel.hrms.entities.concretes.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkDao extends JpaRepository<Link, Integer> {

    Link getByGithubLinkAndLinkedinLink(String githubLink, String linkedinLink);
    Link getByUnemployed_UserId(int unemployedId);
}
