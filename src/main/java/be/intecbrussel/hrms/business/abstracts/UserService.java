package be.intecbrussel.hrms.business.abstracts;

import be.intecbrussel.hrms.core.utilities.results.DataResult;
import be.intecbrussel.hrms.entities.concretes.User;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    DataResult<List<User>> getByMailConfirmed();
}
