package com.ms.email.models;

import com.ms.email.dtos.SmtpDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Getter
@Setter
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

    public static SmtpModel parser(SmtpModel smtpModel, SmtpDTO smtpDTO) {
        smtpModel.setHost(smtpDTO.getHost());
        smtpModel.setPort(smtpDTO.getPort());
        smtpModel.setUsername(smtpDTO.getUsername());
        smtpModel.setPassword(smtpDTO.getPassword());
        smtpModel.setAuth(smtpDTO.getAuth());
        smtpModel.setTls(smtpDTO.getTls());
        return smtpModel;
    }

}
