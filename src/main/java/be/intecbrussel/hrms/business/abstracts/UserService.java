package be.intecbrussel.hrms.business.abstracts;

import java.util.List;

public interface UserService {

    DataResult<List<User>> getAll();
    DataResult<List<User>> getByMailConfirmed();
}
