package com.ms.email.models.services;

import com.ms.email.exception.SmtpNotFoundException;
import com.ms.email.models.entities.SmtpModel;
import com.ms.email.models.repositories.SmtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class SmtpService {

    @Autowired
    SmtpRepository smtpRepository;

    public SmtpModel saveSmtp(SmtpModel smtpModel) {
        return  smtpRepository.save(smtpModel);
    }

    public List<SmtpModel> listAllSmtp(){
        return smtpRepository.findAll();
    }

    public SmtpModel findById(@PathVariable(value = "id") UUID id) {
        return smtpRepository.findById(id).orElseThrow(() -> new SmtpNotFoundException("SMTP not found"));
    }

    public SmtpModel updateSmtp(SmtpModel smtpModel) {
        return smtpRepository.save(smtpModel);
    }

    public void deleteSmtp(UUID id) {
        SmtpModel smtpModel = smtpRepository.findById(id).orElseThrow(() -> new SmtpNotFoundException("SMTP not found."));
        smtpRepository.delete(smtpModel);
    }

}
