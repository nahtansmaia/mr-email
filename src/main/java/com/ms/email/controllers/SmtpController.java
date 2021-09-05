package com.ms.email.controllers;

import com.ms.email.dtos.SmtpDTO;
import com.ms.email.dtos.SmtpResponseDTO;
import com.ms.email.models.SmtpModel;
import com.ms.email.services.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class SmtpController {

    @Autowired
    SmtpService smtpService;

    @PostMapping("/smtp")
    public ResponseEntity<SmtpResponseDTO> sendingEmail(@RequestBody @Valid SmtpDTO smtpDTO) {
        SmtpModel smtpModel =  smtpService.saveSMTP(SmtpModel.parser(smtpDTO));
        return new ResponseEntity<>(SmtpResponseDTO.parser(smtpModel), HttpStatus.CREATED);
    }

    @GetMapping("/smtp")
    public ResponseEntity<List<SmtpModel>> listAllSmtp() {
        return new ResponseEntity<>(smtpService.listAllSMTP(), HttpStatus.OK);
    }

    @GetMapping("/smtp/{id}")
    public ResponseEntity<SmtpModel> findById(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(smtpService.findById(id), HttpStatus.OK);
    }
}
