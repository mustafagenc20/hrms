package be.intecbrussel.hrms.core.concretes;

import be.intecbrussel.hrms.core.abstracts.EmailService;
import be.intecbrussel.hrms.model.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailManager implements EmailService {

   private final JavaMailSender mailSender;

    @Override
    public void sendVerifyEmail(User user, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("HRMS Mail Verification");
        message.setText(
                "Please click the link below to complete your registration\n" +
                        "http://localhost:8081/controller/verification/approve/"
                        + code);
        message.setTo(user.getEmail());
        message.setFrom("hrmstestemailaddress@gmail.com");
        this.mailSender.send(message);
    }
}
