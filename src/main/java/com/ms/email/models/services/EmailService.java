package com.ms.email.models.services;

import com.ms.email.exception.BadRequestException;
import com.ms.email.exception.SmtpNotFoundException;
import com.ms.email.models.constants.EStatusEmail;
import com.ms.email.models.entities.EmailModel;
import com.ms.email.models.entities.SmtpModel;
import com.ms.email.models.repositories.EmailRepository;
import com.ms.email.models.repositories.SmtpRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class EmailService {

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    SmtpRepository smtpRepository;

    public EmailModel sendEmail(EmailModel emailModel) {
        SmtpModel smtpModel = smtpRepository.findById(emailModel.getSmtp())
                .orElseThrow(() -> new SmtpNotFoundException("SMTP not found."));

        try {
            MultiPartEmail message = getMultiPartEmail(emailModel, smtpModel);

            message.send();

            emailModel.setStatusEmail(EStatusEmail.SENT);
            emailModel.setSendDateEmail(LocalDateTime.now());
        } catch (MailException | EmailException e) {
            emailModel.setStatusEmail(EStatusEmail.ERROR);
            log.error("Error to send e-mail", e);
        } finally {
            if (emailModel.getStatusEmail() == null) {
                emailModel.setStatusEmail(EStatusEmail.ERROR);
            }
        }

        return emailRepository.save(emailModel);
    }

    private MultiPartEmail getMultiPartEmail(EmailModel emailModel, SmtpModel smtpModel) throws EmailException {
        MultiPartEmail message = new MultiPartEmail();

        message.setHostName(smtpModel.getHost() != null ? smtpModel.getHost() : "");
        message.setSmtpPort(smtpModel.getPort() != null ? smtpModel.getPort() : 587);
        message.setAuthenticator(new DefaultAuthenticator(smtpModel.getUsername(), smtpModel.getPassword()));
        message.setStartTLSEnabled(smtpModel.getTls());

        message.setFrom(emailModel.getEmailFrom());
        message.addTo(emailModel.getEmailTo());
        message.setSubject(emailModel.getSubject());
        message.addPart(emailModel.getText(), "text/html; charset=UTF-8");

        EmailAttachment attachment = new EmailAttachment();
        File file = new File(emailModel.getDirPart());

        attachment.setPath(emailModel.getDirPart());
        attachment.setDescription(EmailAttachment.ATTACHMENT);
        attachment.setName(file.getName());

        if (!emailModel.getDirPart().isBlank() || !emailModel.getDirPart().isEmpty()) {
            message.attach(attachment);
        }

        return message;
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
