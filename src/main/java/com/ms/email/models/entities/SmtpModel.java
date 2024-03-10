package com.ms.email.models.entities;

import com.ms.email.models.dtos.SmtpDTO;
import lombok.*;

import jakarta.persistence.*;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "smtp")
public class SmtpModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    private String host;
    private Integer port;
    private String username;
    private String password;
    private Boolean auth;
    private Boolean tls;

    public static SmtpModel parser(SmtpDTO smtpDTO) {
        return SmtpModel.builder()
                .id(smtpDTO.getId())
                .host(smtpDTO.getHost())
                .port(smtpDTO.getPort())
                .username(smtpDTO.getUsername())
                .password(smtpDTO.getPassword())
                .tls(smtpDTO.getTls())
                .auth(smtpDTO.getAuth())
                .build();
        }
}
