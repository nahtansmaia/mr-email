package com.ms.email.controllers;

import com.ms.email.models.dtos.EmailDTO;
import com.ms.email.models.entities.EmailModel;
import com.ms.email.models.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel email = emailService.sendEmail(EmailModel.parser(emailDTO));
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }

    @GetMapping("/list-email")
    public ResponseEntity<List<EmailModel>> listAllEmail() {
        return new ResponseEntity<>(emailService.listAllEmail(), HttpStatus.OK);
    }

    @GetMapping("/list-email/{id}")
    public ResponseEntity<EmailModel> findById(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(emailService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/list-email/from/{emailFrom}")
    public ResponseEntity<List<EmailModel>> findByEmailFrom(@PathVariable(value = "emailFrom") String emailFrom) {
        return new ResponseEntity<>(emailService.findByEmailFrom(emailFrom), HttpStatus.OK);
    }

    @GetMapping("/list-email/to/{emailTo}")
    public ResponseEntity<List<EmailModel>> findByEmailTo(@PathVariable(value = "emailTo") String emailTo) {
        return new ResponseEntity<>(emailService.findByEmailTo(emailTo), HttpStatus.OK);
    }

}
