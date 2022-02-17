package be.intecbrussel.hrms.service.concretes;

import be.intecbrussel.hrms.service.abstracts.LinkService;
import be.intecbrussel.hrms.core.utilities.results.*;
import be.intecbrussel.hrms.repository.LinkDao;
import be.intecbrussel.hrms.repository.UnemployedDao;
import be.intecbrussel.hrms.model.entities.Link;
import be.intecbrussel.hrms.model.dtos.LinkDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LinkManager implements LinkService {

    private final LinkDao linkDao;
    private final UnemployedDao unemployedDao;

    @Override
    public Result addLink(LinkDto linkDto) {
        Link link = new Link();
        link.setGithubLink(linkDto.getGithubLink());
        link.setLinkedinLink(linkDto.getLinkedinLink());
        link.setUnemployed(this.unemployedDao.getOne(linkDto.getUnemployedId()));

        this.linkDao.save(link);
        return new SuccessResult("Link added.");
    }

    @Override
    public DataResult<List<Link>> getAll() {
        return new SuccessDataResult<List<Link>>(this.linkDao.findAll());
    }

    @Override
    public DataResult<Link> getByUnemployedId(int unemployedId) {
        return new SuccessDataResult<Link>(this.linkDao.getByUnemployed_UserId(unemployedId));
    }

    @Override
    public Result updateLink(LinkDto linkDto) {
        if (this.linkDao.getByUnemployed_UserId(linkDto.getUnemployedId()) == null) {
            return new ErrorResult("You must add the link first.");
        }
        Link link = this.linkDao.getByUnemployed_UserId(linkDto.getUnemployedId());
        if (link.getGithubLink().equals(linkDto.getGithubLink()) && link.getLinkedinLink().equals(linkDto.getLinkedinLink())) {
            return new ErrorResult("You forgot to update.");
        }
        link.setGithubLink(linkDto.getGithubLink());
        link.setLinkedinLink(linkDto.getLinkedinLink());
        this.linkDao.save(link);
        return new SuccessResult("Links have been updated.");
    }
}
