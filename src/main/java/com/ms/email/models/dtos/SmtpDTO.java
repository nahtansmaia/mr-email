package com.ms.email.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class SmtpDTO {

    private UUID id;

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
