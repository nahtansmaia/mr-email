package com.ms.email.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SmtpNotFoundException extends RuntimeException {

    public SmtpNotFoundException(String message) {
        super(message);
    }
}
