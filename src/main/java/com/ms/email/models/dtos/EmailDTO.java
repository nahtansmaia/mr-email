package com.ms.email.models.dtos;

import com.ms.email.models.constants.EStatusEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

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
