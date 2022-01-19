package be.intecbrussel.hrms.core.abstracts;

public interface EmailService {

    void sendVerifyEmail(User user, String code);
}
