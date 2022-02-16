package be.intecbrussel.hrms.service.abstracts;

import be.intecbrussel.hrms.core.utilities.results.Result;
import be.intecbrussel.hrms.model.entities.User;

public interface VerificationService {

    Result verifyUser(String code);
    String generateCode(User user);
}
