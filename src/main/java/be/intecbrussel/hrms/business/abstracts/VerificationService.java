package be.intecbrussel.hrms.business.abstracts;

public interface VerificationService {

    Result verifyUser(String code);
    String generateCode(User user);
}
