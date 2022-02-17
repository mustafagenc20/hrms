package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.model.entities.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    DataResult<List<User>> getByMailConfirmed();
}
