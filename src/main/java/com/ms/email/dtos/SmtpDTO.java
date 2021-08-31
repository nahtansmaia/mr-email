package com.ms.email.dtos;

import com.ms.email.models.SmtpModel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Properties;

@Data
@Entity
@Getter
@Setter
public class SmtpDTO {

    @NotBlank
    private String host;

    @NotNull
    private Integer port;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private Boolean auth = true;
    private Boolean tls = true;

    public static JavaMailSenderImpl parse(SmtpModel smtpModel) {

        if (smtpModel == null) {
            throw new RuntimeException("SMTP not found.");
        }

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(smtpModel.getHost());
        sender.setUsername(smtpModel.getUsername());
        sender.setPassword(smtpModel.getPassword());
        sender.setPort(smtpModel.getPort() != null ? smtpModel.getPort() : 587);
        sender.setDefaultEncoding("UTF-8");

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", smtpModel.getAuth().toString());
        props.setProperty("mail.smtp.starttls.enable", smtpModel.getTls().toString());
        props.setProperty("mail.smtp.starttls.required", smtpModel.getTls().toString());
        props.put("mail.smtp.timeout", 25000);
        sender.setJavaMailProperties(props);

        return sender;
    }
}
