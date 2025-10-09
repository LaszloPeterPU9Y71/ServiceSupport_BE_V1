package com.service.support.servicesupport_be_v1.service.entity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailingService {

    public void sendNotification(String msg) {
        System.out.println(msg);
    }

    private final JavaMailSender mailSender;

    public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText("<h1>" + htmlContent + "</h1>", true); // true -> HTML

        mailSender.send(message);
        System.out.println("Mail sent successfully");
    }

}
