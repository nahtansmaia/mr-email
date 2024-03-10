package com.ms.email.models.dtos;


import com.ms.email.models.entities.SmtpModel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class SmtpResponseDTO {

    private UUID id;
    private String host;
    private Integer port;
    private String username;
    private Boolean auth;
    private Boolean tls;

    public static SmtpResponseDTO parser(SmtpModel smtpModel) {
        return new SmtpResponseDTO(
                smtpModel.getId(),
                smtpModel.getHost(),
                smtpModel.getPort(),
                smtpModel.getUsername(),
                smtpModel.getAuth(),
                smtpModel.getTls());
    }
}
