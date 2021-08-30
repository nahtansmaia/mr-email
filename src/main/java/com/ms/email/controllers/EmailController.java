package com.ms.email.controllers;

import com.ms.email.dtos.EmailDTO;
import com.ms.email.services.EmailService;
import com.ms.email.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailModel> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel email = new EmailModel();
        EmailModel.parser(email, emailDTO);
        emailService.sendEmail(email);
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

}
