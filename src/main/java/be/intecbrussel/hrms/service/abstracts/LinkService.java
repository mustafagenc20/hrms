package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.Link;
import be.intecbrussel.hrms.model.dtos.LinkDto;

import java.util.List;

public interface LinkService {

    Result addLink(LinkDto linkDto);
    Result updateLink(LinkDto linkDto);
    DataResult<List<Link>> getAll();
    DataResult<Link> getByUnemployedId(int unemployedId);
}
