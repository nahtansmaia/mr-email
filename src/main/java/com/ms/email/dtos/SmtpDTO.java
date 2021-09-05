package com.ms.email.dtos;

import com.ms.email.models.SmtpModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
public class SmtpDTO {

    @NotBlank(message = "Host cannot be empty")
    private String host;

    @NotNull(message = "Port cannot be empty")
    private Integer port;

    @NotBlank(message = "E-mail cannot be empty")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    private String password;

    @NotNull(message = "Auth is a boolean method and cannot be null")
    private Boolean auth = true;

    @NotNull(message = "TLS is a boolean method and cannot be null")
    private Boolean tls = true;

}
