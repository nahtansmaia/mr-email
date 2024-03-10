package com.ms.email.controllers;

import com.ms.email.models.dtos.SmtpDTO;
import com.ms.email.models.dtos.SmtpResponseDTO;
import com.ms.email.models.entities.SmtpModel;
import com.ms.email.models.services.SmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class SmtpController {

    @Autowired
    SmtpService smtpService;

    @PostMapping("/smtp")
    public ResponseEntity<SmtpResponseDTO> sendingSmtp(@RequestBody @Valid SmtpDTO smtpDTO) {
        SmtpModel smtpModel =  smtpService.saveSmtp(SmtpModel.parser(smtpDTO));
        return new ResponseEntity<>(SmtpResponseDTO.parser(smtpModel), HttpStatus.CREATED);
    }

    @GetMapping("/smtp")
    public ResponseEntity<List<SmtpModel>> listAllSmtp() {
        return new ResponseEntity<>(smtpService.listAllSmtp(), HttpStatus.OK);
    }

    @GetMapping("/smtp/{id}")
    public ResponseEntity<SmtpModel> findById(@PathVariable(value = "id") UUID id) {
        return new ResponseEntity<>(smtpService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/smtp")
    public ResponseEntity<SmtpResponseDTO> updateSmtp(@RequestBody @Valid SmtpDTO smtpDTO) {
        SmtpModel smtpModel = smtpService.updateSmtp(SmtpModel.parser(smtpDTO));
        return new ResponseEntity<>(SmtpResponseDTO.parser(smtpModel), HttpStatus.OK);
    }

    @DeleteMapping("/smtp/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSmtp(@PathVariable("id") UUID id) {
        smtpService.deleteSmtp(id);
    }
}
