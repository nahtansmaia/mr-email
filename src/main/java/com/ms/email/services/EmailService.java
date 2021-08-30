package com.ms.email.services;

import com.ms.email.enums.EStatusEmail;
import com.ms.email.exception.BadRequestException;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    JavaMailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(EStatusEmail.SENT);
        } catch (MailException e){
            emailModel.setStatusEmail(EStatusEmail.ERROR);
        } finally {
            return emailRepository.save(emailModel);
        }
    }

    public List<EmailModel> listAllEmail() {
        return emailRepository.findAll();
    }

    public EmailModel findById(@PathVariable(value = "id") UUID id) {
        return emailRepository.findById(id).orElseThrow(() -> new BadRequestException("Email not found"));
    }

    public List<EmailModel> findByEmailFrom(@PathVariable(value = "emailFrom") String emailFrom) {
        return emailRepository.findByEmailFrom(emailFrom);
    }

    public List<EmailModel> findByEmailTo(@PathVariable(value = "emailTo") String emailTo) {
        return emailRepository.findByEmailTo(emailTo);
    }

}
