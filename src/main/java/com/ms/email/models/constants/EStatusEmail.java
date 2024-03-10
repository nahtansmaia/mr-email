package com.ms.email.models.constants;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EStatusEmail {

    SENT(1, "SENT", "E-mail successfully sent"),
    ERROR(-1, "ERROR", "There was an error sending the e-mail");

    private Integer code;
    private String attribute;
    private String message;

}
