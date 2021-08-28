package com.ms.email.models;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.enums.EStatusEmail;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "email")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private EStatusEmail statusEmail;

    public static EmailModel parser(EmailModel emailModel, EmailDTO emailDTO) {
        emailModel.setOwnerRef(emailDTO.getOwnerRef());
        emailModel.setEmailFrom(emailDTO.getEmailFrom());
        emailModel.setEmailTo(emailDTO.getEmailTo());
        emailModel.setSubject(emailDTO.getSubject());
        emailModel.setText(emailDTO.getText());
        return emailModel;
    }
}
