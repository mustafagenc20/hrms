package be.intecbrussel.hrms.core.abstracts;

import be.intecbrussel.hrms.model.entities.User;

public interface EmailService {

    void sendVerifyEmail(User user, String code);
}
