package com.ms.email.dtos;

import com.ms.email.enums.EStatusEmail;
import com.ms.email.models.SmtpModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class EmailDTO {

    @NotBlank
    private String ownerRef;

    @NotBlank
    @Email
    private String emailFrom;

    @NotBlank
    @Email
    private String emailTo;

    @NotBlank
    private String subject;

    @NotBlank
    private String text;

    @NotNull
    private String dirPart;

    @NotNull
    private UUID smtp;

    private LocalDateTime sendDateEmail;
    private EStatusEmail statusEmail;

}
