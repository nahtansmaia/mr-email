package com.ms.email.models;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.enums.EStatusEmail;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "email")
public class EmailModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emailId;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String dirPart;
    private UUID smtp;

    @Column(columnDefinition = "TEXT")
    private String text;
    private LocalDateTime sendDateEmail;
    private EStatusEmail statusEmail;

    public static EmailModel parser(EmailDTO emailDTO) {
        return EmailModel.builder()
                .ownerRef(emailDTO.getOwnerRef())
                .emailFrom(emailDTO.getEmailFrom())
                .emailTo(emailDTO.getEmailTo())
                .subject(emailDTO.getSubject())
                .dirPart(emailDTO.getDirPart())
                .smtp(emailDTO.getSmtp())
                .text(emailDTO.getText())
                .sendDateEmail(emailDTO.getSendDateEmail())
                .statusEmail(emailDTO.getStatusEmail())
                .build();
    }
}
