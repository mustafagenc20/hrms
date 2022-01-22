package be.intecbrussel.hrms.core.concretes;

import be.intecbrussel.hrms.core.abstracts.EmailService;
import be.intecbrussel.hrms.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailManager implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendVerifyEmail(User user, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("HRMS Mail Verification");
        message.setText(
                "Please click the link below to complete your registration.\n" +
                        "http://localhost:8080/api/verification/approve/"
                        + code);
        message.setTo(user.getEmail());
        message.setFrom("hrmstestemailaddress@gmail.com");
        this.mailSender.send(message);
    }
}
